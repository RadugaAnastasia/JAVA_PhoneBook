package Final_work;
/**
 * Реализуйте структуру телефонной книги с помощью HashMap.
 * Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
 * их необходимо считать, как одного человека с разными телефонами.
 * Вывод должен быть отсортирован по убыванию числа телефонов.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        addNumber(phoneBook,"Маша", "1212");
        addNumber(phoneBook,"Маша", "1200");
        addNumber(phoneBook,"Саша", "1211");
        addNumber(phoneBook,"Петя", "1010");
        addNumber(phoneBook,"Петя", "1214");
        addNumber(phoneBook,"Вася", "1515");
        addNumber(phoneBook,"Света", "1718");
        addNumber(phoneBook,"Маша", "1415");
        printBook(phoneBook);
    }
    public static void addNumber(HashMap<String,List<String>> phoneBook, String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public static void printBook(HashMap<String,List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        sortedList.sort((a,b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
        System.out.println("---------------------------------------------");
        System.out.println("Телефонный справочник: ");
        System.out.println("---------------------------------------------");
        for (Map.Entry<String, List<String>> entry : sortedList) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("---------------------------------------------");
    }
}
