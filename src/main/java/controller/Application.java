package controller;


import dao.DbActions;
import dao.MongoConnectionDAO;
import services.UserOptions;
import util.Console;

import static util.Console.consoleScanner;
import static util.Console.printMenu;

public class Application {

    private final UserOptions options;
//    private final MongoConnectionDAO connection;
//    private final DbActions dbActions;

    public Application() {
        this.options = new UserOptions();
//        this.connection = new MongoConnectionDAO();
//        this.dbActions = new DbActions();
    }

    public void run() {

        printMenu();
        int option = consoleScanner().nextInt();


        switch (option) {
            case 1:
                registerUser();
                break;

            case 2:
                findUser();
                break;

            case 3:
                printUser();
                break;

            default:
                System.out.println("Ivalid Option");
                break;
        }
    }

    private void registerUser() {

        int cod;

        Console.printEnterName();
        String name = consoleScanner().next();

        Console.printEnterCod();
        cod = consoleScanner().nextInt();

        Console.printEnterUserFunction();
        int function = consoleScanner().nextInt();

        options.registerUser(name, cod, function);
    }

    private void findUser() {

        int cod;

        System.out.println();

        Console.printEnterCod();
        cod = consoleScanner().nextInt();

        options.findUser(cod);
    }

    private void printUser() {

        int cod;

        Console.printEnterCod();
        cod = consoleScanner().nextInt();

        options.printUser(cod);
    }
}
