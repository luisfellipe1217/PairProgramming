package util;

import java.util.Scanner;

public class Console {

    public static void printMenu() {

        System.out.println("--------User registration---------- \n");
        System.out.println("1. Register new user \n"
                + "2. Find user \n"
                + "3. Print user \n");
    }

    public static void printEnterName() {
        System.out.println();
        System.out.println("Enter user name: ");
    }

    public static void printEnterCod() {
        System.out.println("\n Enter user id: ");
    }
    public static void printEnterUserFunction() {
        System.out.println("\n Enter user function: 1 - Manager .... 2 - Employee");
    }

    public static Scanner consoleScanner() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }


}
