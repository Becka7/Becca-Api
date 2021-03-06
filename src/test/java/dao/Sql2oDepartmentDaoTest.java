package dao;

import models.Department;
import models.News;
import models.User;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {
    private static Sql2oDepartmentDao departmentDao;
    private static Sql2oNewsDao newsDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        departmentDao = new Sql2oDepartmentDao(DatabaseRule.sql2o);
        newsDao = new Sql2oNewsDao(DatabaseRule.sql2o);
        conn = DatabaseRule.sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentDao.clearAll();
        newsDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void getAll() throws Exception {
        Department department = setupDepartment();
        Department department1 = setupDepartment();
        assertEquals(2, departmentDao.getAll().size());
    }

    @Test
    public void deleteById() throws Exception {
        Department testDepartment = setupDepartment();
        Department otherDepartment = setupDepartment();
        assertEquals(2, departmentDao.getAll().size());
        departmentDao.deleteById(testDepartment.getId());
        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Department testDepartment = setupDepartment();
        Department otherDepartment = setupDepartment();
        departmentDao.clearAll();
        assertEquals(0, departmentDao.getAll().size());
    }
    @Test
    public void getAllNewsForADepartmentReturnsNewsCorrectly() throws Exception {
        News news  = new News("Becka...the girl with the dragon tattoo");
        newsDao.add(news);
        News secondNews  = new News("Into the Badlands");
        newsDao.add(secondNews);
        Department department = setupDepartment();
        departmentDao.add(department);
        departmentDao.addDepartmentToNews(department,news);
        departmentDao.addDepartmentToNews(department,secondNews);

        News[] testNews = {news, secondNews};
        List<News> test2News = departmentDao.getAllNewsForADepartment(department.getId());
        for (News n:test2News
        ) {
            System.out.println("from dao "+n.getPost());
        }
        assertEquals(2,departmentDao.getAllNewsForADepartment(department.getId()).size());

        assertEquals(Arrays.asList(testNews), departmentDao.getAllNewsForADepartment(department.getId()));
    }


    public Department setupDepartment(){
        Department department =  new Department("Fashion","Dress to kill on a budget",34);
        departmentDao.add(department);
        return department;
    }
    public News setupNews(){
        News news =  new News("Most citizens get vaccinated");
        newsDao.add(news);
        return news;
    }


}