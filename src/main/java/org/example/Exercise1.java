package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise1 {
    public static float getFloatNumber() {
        float result = 0;
        boolean flag = true;

        while (flag) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Input float number:");
                result = scanner.nextFloat();
                flag = false;
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input.Try again.");
            }
        }
        return result;
    }
}
