package org.example;

//Первый семинар.
//        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//        Пункты реализовать в методе main
//        *Пункты реализовать в разных методах
//
//        int i = new Random().nextInt(k); //это кидалка случайных чисел!)

import java.util.Random;
import java.util.Stack;

public class Lesson1 {
    public static int getRandomNumber() {
         Random random = new Random();
        return random.nextInt(2000);
    }

    public static int getNumberOfMostSignificantBit(int number) {
        String tbs = Integer.toBinaryString(number);
        return tbs.length();
    }

    public static int[] getMultiplesNumbers(int minValue , int maxValue, int number){
        int counter = 0;
        int[] tempArray =new int[Math.abs(minValue) + Math.abs(maxValue)];
        for(int k = minValue; k < maxValue; k++) {
            if (k % number == 0) {
                tempArray[counter] = k;
                counter++;
            }
        }
        int[] result = new int[counter];
        System.arraycopy(tempArray, 0, result, 0, counter);
        return result;
    }

    public static int[] getNonMultiplesNumbers(int minValue , int maxValue, int number){
        int counter = 0;
        int[] tempArray =new int[Math.abs(minValue) + Math.abs(maxValue)];
        for(int k = minValue; k < maxValue; k++) {
            if (k % number != 0) {
                tempArray[counter] = k;
                counter++;
            }
        }
        int[] result = new int[counter];
        System.arraycopy(tempArray, 0, result, 0, counter);
        return result;
    }
}
