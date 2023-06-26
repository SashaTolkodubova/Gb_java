//Организовать ввод и хранение данных пользователей. ФИО возраст и пол
//        вывод в формате Фамилия И.О. возраст пол
//        добавить возможность выхода или вывода списка отсортированного по возрасту!)
//        *реализовать сортировку по возрасту с использованием индексов
//        *реализовать сортировку по возрасту и полу с использованием индексов
package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Lesson4 {
    public static void exercise() {
        ArrayList<String> fullName = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        getMenu(fullName, age, gender);
    }


    public static void getMenu(ArrayList<String> fullName,
                               ArrayList<Integer> age,
                               ArrayList<String> gender) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Input:
                    "1" for add user,
                    "2" print users,
                    "3" for print sorted users by age,
                    "4" for print sorted users by age and gender,
                    "0" for exit:""");
            String answer = scanner.nextLine();
            if (answer.equals("1")) {
                inputUser(fullName, age, gender);
            } else if (answer.equals("2")) {
                printUsers(fullName, age, gender);
            } else if (answer.equals("3")) {
                printUsers(fullName, age, gender, sortByAge(age));
            } else if (answer.equals("4")) {
                printUsers(fullName, age, gender, sortByAgeAndGender(age, gender));
            } else if (answer.equals("0")) {
                flag = false;
            } else {
                System.out.println("Incorrect input");
            }
        }
    }


    public static void inputUser(ArrayList<String> fullName,
                                 ArrayList<Integer> age,
                                 ArrayList<String> gender) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter users data.");
        System.out.println("Full name: ");
        fullName.add(scanner.nextLine());
        System.out.println("Age: ");
        age.add(Integer.parseInt(scanner.nextLine()));
        System.out.println("Gender: ");
        gender.add(scanner.nextLine());
    }


    public static ArrayList<Integer> sortByAge(ArrayList<Integer> agesArray) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < agesArray.size(); i++) {
            indexes.add(i);
        }
        for (int n = 0; n < agesArray.size() - 1; n++) {
            for (int k = 0; k < agesArray.size() - n - 1; k++) {
                if (agesArray.get(indexes.get(k)) > agesArray.get(indexes.get(k + 1))) {
                    int temp = indexes.get(k);
                    indexes.set(k, indexes.get(k + 1));
                    indexes.set(k + 1, temp);
                }
            }
        }
        return indexes;
    }


    public static ArrayList<Integer> sortByAgeAndGender(ArrayList<Integer> age,
                                                   ArrayList<String> gender) {
        ArrayList<Integer> sortedByAgeIndexes = sortByAge(age);
        ArrayList<Integer> maleIndexes = new ArrayList<>();
        ArrayList<Integer> femaIndexes = new ArrayList<>();
        ArrayList<Integer> resultIndexes = new ArrayList<>();
        for (Integer i : sortedByAgeIndexes) {
            if (gender.get(i).equals("m")) {
                maleIndexes.add(i);
            } else {
                femaIndexes.add(i);
            }
        }
        resultIndexes.addAll(maleIndexes);
        resultIndexes.addAll(femaIndexes);
        return resultIndexes;
    }


    public static void printUsers(ArrayList<String> fullName,
                                  ArrayList<Integer> age,
                                  ArrayList<String> gender,
                                  ArrayList<Integer> sortedIndexes) {
        for (Integer i : sortedIndexes) {
            System.out.print(fullName.get(i)
                    + " "
                    + age.get(i)
                    + " "
                    + gender.get(i)
                    + "\n");
        }
    }


    public static void printUsers(ArrayList<String> fullName,
                                  ArrayList<Integer> age,
                                  ArrayList<String> gender) {
        ArrayList<Integer> sortedIndexes = new ArrayList<>();
        for (int i = 0; i < fullName.size(); i++) {
            sortedIndexes.add(i);
        }
        for (Integer i : sortedIndexes) {
            System.out.print(fullName.get(i)
                    + " "
                    + age.get(i)
                    + " "
                    + gender.get(i)
                    + "\n");
        }
    }
}
