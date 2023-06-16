package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int i = Lesson1.getRandomNumber();
        int n = Lesson1.getNumberOfMostSignificantBit(i);
        int[] m1 = Lesson1.getMultiplesNumbers(i, Short.MAX_VALUE, n);
        int[] m2 = Lesson1.getNonMultiplesNumbers(Short.MIN_VALUE, i, n);
        System.out.println(i);
        System.out.println(n);
        System.out.println(Arrays.toString(m1));
        System.out.println(Arrays.toString(m2));
    }
}