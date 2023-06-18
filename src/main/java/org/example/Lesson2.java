//Формат сдачи: ссылка на подписанный git-проект.
//
//        Задание
//
//        Дана строка sql-запроса "select * from students where ".
//        Сформируйте часть WHERE этого запроса, используя StringBuilder.
//        Данные для фильтрации приведены ниже в виде json-строки.
//        Если значение null, то параметр не должен попадать в запрос.
//        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//
//        Дополнительные задания
//
//        Дана json-строка (можно сохранить в файл и читать из файла)
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
//        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder,
//        создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
//
//        *Сравнить время выполнения замены символа "а" на "А" любой строки содержащей >1000 символов
//        средствами String и StringBuilder.
//        *Дана строка: ".3 + 1.56 = " подсчитать результат и добавить к строке.

package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;


public class Lesson2 {
    public static String getSqlQuery() throws Exception {
        String sqlString = "select * from students where ";
        int counterOfClauses = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sqlString);
        Path filePath = Path.of("resources/user.json");
        String readFromFile = Files.readString(filePath);
        String user = readFromFile.substring(1, readFromFile.length() - 1);
        String[] userArr = user.split(",");


        for (String clause : userArr) {
            String[] clauseArr = clause.split(":");
            String param = clauseArr[0].strip();
            String value = clauseArr[1].strip();

            if (!value.equals("\"null\"")) {
                if (counterOfClauses != 0) stringBuilder.append(" and ");
                stringBuilder.append(param, 1, param.length() - 1);
                stringBuilder.append("=");
                stringBuilder.append(value);
                counterOfClauses++;
            }
        }
        return stringBuilder.toString();

    }

    public static String getMarks() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = new JSONParser().parse(new FileReader("resources/students.json"));
        JSONArray jsonArray = (JSONArray) obj;
        for (Object arr : jsonArray) {
            JSONObject jo = (JSONObject) arr;
            stringBuilder.append("Студент %s получил %s по предмету %s.\n".formatted(
                    jo.get("фамилия"),
                    jo.get("оценка"),
                    jo.get("предмет")));
        }
        return stringBuilder.toString();
    }

    public static String measureTime() {
        String firstA = "a".repeat(1000);
        String secondA = "a".repeat(1000);

        long startTime1 = System.nanoTime();
        firstA.replace('a', 'A');
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder(secondA);
        while (stringBuilder.indexOf("a") != -1) {
            int i = stringBuilder.indexOf("a");
            stringBuilder.replace(i, i + 1, "A");
        }
        long endTime2 = System.nanoTime();

        long firstDuration = (endTime1 - startTime1);
        long secondDuration = (endTime2 - startTime2);

        return "Duraion String is %d nanoseconds.\nDuraion StringBuilder is %d nanoseconds."
                .formatted(firstDuration, secondDuration);
    }

    public static String getResult(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        String expression = string.substring(0, string.indexOf("="));
        var arrString = expression.split(" ");
        double result = 0;
        double number1 = Double.parseDouble(arrString[0]);
        double number2 = Double.parseDouble(arrString[2]);
        if (arrString[1].equals("+")) {
            result = number1 + number2;
        } else if (arrString[1].equals("-")) {
            result = number1 - number2;
        } else if (arrString[1].equals("*")) {
            result = number1 * number2;
        } else if (arrString[1].equals("/")) {
            result = number1 / number2;
        } else {
            return "unknown operator";
        }
        stringBuilder.append(result);
        return stringBuilder.toString();
    }
}


