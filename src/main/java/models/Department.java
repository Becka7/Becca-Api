package models;

import java.util.Objects;

public class Department {
    private String name;
    private  String description;
    private int employees;
    private  int id;

    public Department(String name, String description, int employees){
        this.name = name;
        this.description = description;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getEmployees() {
        return employees;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.employees = employees;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description) && employees == that.employees;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, employees, id);
    }

}
