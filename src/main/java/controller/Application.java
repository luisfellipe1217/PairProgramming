package controller;


import dao.DbActions;
import dao.MongoConnectionDAO;
import services.UserOptions;
import util.Console;

import static util.Console.consoleScanner;
import static util.Console.printMenu;

public class Application {

    private UserOptions options = new UserOptions();
    private MongoConnectionDAO connection = new MongoConnectionDAO();
    private DbActions dbActions = new DbActions();

    public void run() {

        printMenu();
        int option = consoleScanner().nextInt();
        int cod;

        switch (option) {
            case 1:
                Console.printEnterName();
                String name = consoleScanner().next();
                Console.printEnterCod();
                cod = consoleScanner().nextInt();
                Console.printEnterUserFunction();
                int function = consoleScanner().nextInt();
                options.registerUser(connection, dbActions, name, cod, function);
                break;

            case 2:
                System.out.println();
                Console.printEnterCod();
                cod = consoleScanner().nextInt();
                options.findUser(connection, dbActions, cod);
                break;

            case 3:
                Console.printEnterCod();
                cod = consoleScanner().nextInt();
                options.printUser(connection, dbActions, cod);
                break;

            default:

                System.out.println("Ivalid Option");
                break;
        }

    }

}
