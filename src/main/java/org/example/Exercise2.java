package org.example;

public class Exercise2 {
    public static void method(int[] intArray, int d, int arrayIndex) {
        try {
            double catchedRes1 = (double) intArray[arrayIndex] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException exception) {
            System.out.println("Catching exception: " + exception);
        }
    }
}
