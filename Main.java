package com.nikos;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ShoppingList shoppingList = new ShoppingList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        while (!quit) {
            printMenu();
            System.out.println("Δώστε την επιλογή σας: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    shoppingList.printList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nΔώστε μια επιλογή από το 1 ως το 6 για να επιλέξετε μια ενέργεια: ");
        System.out.println("\t 0 - Εκτύπωση του μενού επιλογών.");
        System.out.println("\t 1 - Εκτύπωση της λίστας.");
        System.out.println("\t 2 - Προσθήκη νέου αντικειμένου στη λίστα.");
        System.out.println("\t 3 - Τροποποίηση ενός αντικειμένου στη λίστα.");
        System.out.println("\t 4 - Αφαίρεση ενός αντικειμένου από τη λίστα.");
        System.out.println("\t 5 - Αναζήτηση ενός αντικειμένου από τη λίστα.");
        System.out.println("\t 6 - Έξοδος από την εφαρμογή.");
    }

    public static void addItem() {
        System.out.print("Δώστε το όνομα του αντικειμένου: ");
        shoppingList.addItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Τρέχων όνομα: ");
        String itemNo = scanner.nextLine();
        System.out.print("Νέο όνομα: ");
        String newItem = scanner.nextLine();
        shoppingList.modifyItem(itemNo, newItem);
    }

    public static void removeItem() {
        System.out.print("Δώστε το όνομα του αντικειμένου: ");
        String itemNo = scanner.nextLine();
        shoppingList.removeItem(itemNo);
    }

    public static void searchForItem() {
        System.out.print("Δώστε το όνομα του αντικειμένου που θέλετε να αναζητήσετε: ");
        String searchItem = scanner.nextLine();
        if(shoppingList.onFile(searchItem)) {
            System.out.println("Βρέθηκε στη λίστα το αντικείμενο " + searchItem);
        } else {
            System.out.println("Το αντικείμενο " + searchItem + ", δε βρέθηκε στη λίστα.");
        }
    }

}
