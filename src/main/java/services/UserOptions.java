package services;

import dao.DbActions;
import dao.MongoConnectionDAO;
import model.User;
import model.UserBuilder;
import util.Console;

import static util.Console.consoleScanner;

public class UserOptions {

    private User user;

    public void registerUser(MongoConnectionDAO connection, DbActions dbManager, String name, int id, int function) {

        if (function == 1){
            user = UserBuilder.anUser().userId(id).userName(name).isAEmployee().finalUser();
        } else if (function == 2){
            user = UserBuilder.anUser().userId(id).userName(name).isAManager().finalUser();
        }

        dbManager.insertObject(user.getId(), user.getName(), user.getFunction(), user.getSalary(), connection);
        dbManager.printObject(user.getId(), connection);
    }

    public void findUser(MongoConnectionDAO connection, DbActions dbManager, int cod) {

        String user = dbManager.findObject(cod, connection).one().toString();
        System.out.println("The user is:" + user);
    }

    public void printUser(MongoConnectionDAO connection, DbActions dbManager, int cod) {

        dbManager.printObject(cod, connection);
    }
}
