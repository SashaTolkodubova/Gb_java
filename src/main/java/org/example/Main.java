// 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
// необходимо повторно запросить у пользователя ввод данных.
//
// 2. Если необходимо, исправьте данный код
//        (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//
// 3. Дан следующий код, исправьте его там, где требуется
//        (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//
// 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
package org.example;

public class Main {
    public static void main(String[] args) {

//        System.out.println(Exercise1.getFloatNumber());

//        int[] array = new int[4];
//        array[0] = 19;
//        Exercise2.method(array,0,0);

        try {
            Exercise4.inputWithoutBlankLine();
        } catch (BlankException exception) {
            System.out.println(exception);
        }
    }

}

