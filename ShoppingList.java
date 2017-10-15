package com.nikos;

import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<String> shoppingList = new ArrayList<String>();

    public void addItem(String item) {

        shoppingList.add(item);
    }

    public void printList() {
        System.out.println("Έχετε " + shoppingList.size() + " αντικείμενα στη λίστα");
        for(int i = 0; i< shoppingList.size(); i++) {
            System.out.println((i+1) + ". " + shoppingList.get(i));
        }
    }

    public void modifyItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if(position >= 0) {
            modifyItem(position, newItem);
        }

    }
    private void modifyItem(int position, String newItem) {
        shoppingList.set(position, newItem);
        System.out.println("Το αντικείμενο στη θέση " + (position+1) + " έχει τροποποιηθεί.");
    }

    public void removeItem(String item) {
        int position = findItem(item);
        if(position >= 0) {
            removeItem(position);
        }
    }
    private void removeItem(int position) {
        shoppingList.remove(position);
    }

    private int findItem(String searchItem) {
        return shoppingList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if(position >=0) {
            return true;
        }

        return false;
    }
}