//Задание
//        Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать,
//        что во входной структуре будут повторяющиеся имена с разными телефонами,
//        их необходимо считать, как одного человека с разными телефонами.
//        Вывод должен быть отсортирован по убыванию числа телефонов.

package org.example;


import java.util.ArrayList;
import java.util.HashMap;


public class Lesson5 {
    public static HashMap<String, ArrayList<Integer>> getPhoneBook(HashMap<Integer, String> phoneBook) {
        HashMap<String, ArrayList<Integer>> newPhoneBook = new HashMap<>();
        phoneBook.forEach((key, value) -> {
            if (newPhoneBook.containsKey(value)) {
                ArrayList<Integer> newArr1 = new ArrayList<>(newPhoneBook.get(value));
                newArr1.add(key);
                newPhoneBook.put(value, newArr1);
            } else {
                ArrayList<Integer> newArr2 = new ArrayList<>();
                newArr2.add(key);
                newPhoneBook.put(value, newArr2);
            }
        });
        return newPhoneBook;
    }


    public static void printPhoneBook(HashMap<String, ArrayList<Integer>> phoneBook) {
        ArrayList<String> keys = new ArrayList<>(phoneBook.keySet());
        keys.sort((o1, o2) -> phoneBook.get(o2).size() - phoneBook.get(o1).size());
        for (String key : keys) {
            System.out.println(key);
            for (Integer i : phoneBook.get(key)) {
                System.out.println("    " + i);
            }
        }
    }
}
