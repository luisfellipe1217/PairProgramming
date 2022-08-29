package services;

import dao.DbActions;
import dao.MongoConnectionDAO;
import model.User;
import model.UserBuilder;
import util.Console;

import static util.Console.consoleScanner;

public class UserOptions {

    private User user;
    private final DbActions dbManager;

    public UserOptions(){
        this.dbManager = new DbActions();
    }

    public void registerUser(String name, Integer id, Integer function) {

        if (function == 1){
            user = UserBuilder.anUser().userId(id).userName(name).isAEmployee().finalUser();
        } else if (function == 2){
            user = UserBuilder.anUser().userId(id).userName(name).isAManager().finalUser();
        }

        dbManager.insertObject(user.getId(), user.getName(), user.getFunction(), user.getSalary());
        dbManager.printObject(user.getId());
    }

    public void findUser(Integer cod) {

        String user = String.valueOf(dbManager.findObject(cod).one());
        System.out.println("The user is:" + user);
    }

    public void printUser(Integer cod) {
        dbManager.printObject(cod);
    }
}
