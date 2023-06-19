//Задание
//
//        Пусть дан произвольный список из 100 целых чисел.
//
//        1) Нужно удалить из него чётные числа
//        2) Найти минимальное значение
//        3) Найти максимальное значение
//        4) Найти среднее значение

package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Lesson3 {
    public static void exercise() {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            arrayList.add(random.nextInt(100));
        }
        arrayList.removeIf(i -> i % 2 == 0);
        int minValue = arrayList.get(0);
        int maxValue = arrayList.get(0);
        int sum = 0;

        for (int i : arrayList) {
            if (i < minValue) minValue = i;
            if (i > maxValue) maxValue = i;
            sum += i;
        }
        int average = sum / arrayList.size();
        System.out.println(arrayList);
        System.out.printf("Минимальное значение: %d%n", minValue);
        System.out.printf("Максимальное значение: %d%n", maxValue);
        System.out.printf("Среднее значение: %d%n", average);
    }

}
