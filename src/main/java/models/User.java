//package models;
//
//import java.util.Objects;
//
//public class User {
//    private int id;
//    private String name;
//    private int departmentId;
//    private String role;
//
//
//    public  User(String name,String position, String role, int departmentId){
//        this.name = name;
//        this.departmentId = departmentId;
//        this.role = role;
//    }
//
//
//
//    public String getName()
//    {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getRole() {
//        return role;
//    }
//
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public int getDepartmentId() {
//        return departmentId;
//    }
//    public void setDepartmentId(int departmentId) {
//        this.departmentId = departmentId;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//        User that = (User) o;
//        return id == that.id &&
//                Objects.equals(name, that.name) && Objects.equals(role, that.role) && departmentId == that.departmentId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name,  role, id,departmentId);
//    }
//}
