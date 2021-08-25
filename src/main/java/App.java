//import com.google.gson.Gson;
//import dao.*;
//import exceptions.ApiException;
//import models.Department;
//import models.News;
//import models.User;
//import org.sql2o.Sql2o;
//import org.sql2o.Connection;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static spark.Spark.*;
//
//
//public class App {
//    static int getHerokuAssignedPort() {
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        if (processBuilder.environment().get("PORT") != null) {
//            return Integer.parseInt(processBuilder.environment().get("PORT"));
//        }
//        return 4567;
//    }
//    public static void main(String[] args) {
//        port(getHerokuAssignedPort());
//
//        Sql2oDepartmentDao departmentDao;
//        Sql2oNewsDao newsDao;
//        Sql2oUserDao userDao;
//        Connection conn;
//        Gson gson = new Gson();
//        departmentDao = new Sql2oDepartmentDao(DB.sql2o);
//        newsDao = new Sql2oNewsDao(DB.sql2o);
//        userDao = new Sql2oUserDao(DB.sql2o);
//        conn = DB.sql2o.open();
//
//        get("/", "application/json", (req, res) -> {
//            System.out.println(departmentDao.getAll());
//            if(departmentDao.getAll().size() > 1){
//                return gson.toJson(departmentDao.getAll());
//            } else {
//                return "{\"message\":\"Hey there ....No departments are listed yet ...Management Becka.\"}";
//            }
//        });
//
//        post("/departments/:departmentId/users/new", "application/json", (req, res) -> {
//            int departmentId = Integer.parseInt(req.params("departmentId"));
//            User user = gson.fromJson(req.body(), User.class);
//            user.setDepartmentId(departmentId);
//            userDao.add(user);
//            res.status(201);
//            return gson.toJson(user);
//        });
//
//        post("/news/new", "application/json", (req, res) -> {
//            News news = gson.fromJson(req.body(), News.class);
//            newsDao.add(news);
//            res.status(201);
//            return gson.toJson(news);
//        });
//
//        get("/departments", "application/json", (req, res) -> {
//            System.out.println(departmentDao.getAll());
//
//            if(departmentDao.getAll().size() > 0){
//                return gson.toJson(departmentDao.getAll());
//            } else {
//                return "{\"message\":\"Hey there ....No departments are listed yet ...Management Becka\"}";
//            }
//        });
//
//        get("/departments/:id", "application/json", (req, res) -> {
//            int departmentId = Integer.parseInt(req.params("id"));
//            Department departmentToFind = departmentDao.findById(departmentId);
//            if (departmentToFind == null){
//                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
//            }
//            return gson.toJson(departmentToFind);
//        });
//
//        get("/departments/:id/users", "application/json", (req, res) -> {
//            int departmentId = Integer.parseInt(req.params("id"));
//
//            Department departmentToFind = departmentDao.findById(departmentId);
//            List<User> allUsers;
//
//            if (departmentToFind == null){
//                throw new ApiException(404, String.format("Ooops no such department: \"%s\" exists", req.params("id")));
//            }allUsers = userDao.getAllUsersForADepartment(departmentId);
//
//            return gson.toJson(allUsers);
//        });
//
//        get("/news", "application/json", (req, res) -> {
//            return gson.toJson(newsDao.getAll());
//        });
//
//        get("/users", "application/json", (req, res) -> {
//            res.type("application/json");
//            return gson.toJson(userDao.getAll());
//        });
//
//        //CREATE
//        post("/department/new", "application/json", (req, res) -> {
//            Department department = gson.fromJson(req.body(), Department.class);
//            departmentDao.add(department);
//            res.status(201);
//            return gson.toJson(department);
//        });
//
//        after((req, res) ->{
//            res.type("application/json");
//        });
//
//    }
//}
