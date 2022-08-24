package model;

public class UserBuilder {

    private User user;


    private UserBuilder(){}

    public static UserBuilder anUser(){
        UserBuilder factory = new UserBuilder();
        factory.user = new User();
        return factory;
    }

    public UserBuilder userId(int id){
        user.setId(id);
        return this;
    }

    public UserBuilder userName(String name){
        user.setName(name);
        return this;
    }

    public UserBuilder isAEmployee(){
        user.setSalary(1500.00);
        user.setFunction("FactoryWorker");
        return this;
    }
    public UserBuilder isAManager(){
        user.setFunction("FactoryManager");
        user.setSalary(3000.00);
        return this;
    }

    public User finalUser(){
        return user;
    }
}
