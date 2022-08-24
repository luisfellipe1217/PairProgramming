package model;

public class User{

    private int id;
    private String name;
    private String function;
    private double salary;

    public User(){}

    public User(int id, String name, String function, double salary) {
        this.id = id;
        this.name = name;
        this.function = function;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
