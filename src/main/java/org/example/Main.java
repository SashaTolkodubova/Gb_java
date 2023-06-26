package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> phoneBook = new HashMap<>();
        phoneBook.put(1111, "John Doe ");
        phoneBook.put(2222, "Jane Doe ");
        phoneBook.put(3333, "John Doe ");
        phoneBook.put(4444, "John Doe ");
        phoneBook.put(5555, "Jane Doe ");
        phoneBook.put(6666, "John Doe ");
        phoneBook.put(7777, "Jane Doe ");
        phoneBook.put(8888, "Baby Doe");

        Lesson5.printPhoneBook(Lesson5.getPhoneBook(phoneBook));
    }
}
