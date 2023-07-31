package org.example;

import java.util.Scanner;

public class Exercise4 {
    public static void inputWithoutBlankLine() throws BlankException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        if (scanner.nextLine().isBlank()) {
            throw new BlankException("Пустые строки вводить нельзя.");
        }
    }
}
