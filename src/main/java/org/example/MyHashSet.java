//Разработать программу, имитирующую поведение коллекции HashSet.
// В программе содать метод add добавляющий элемент,
// метод toString возвращающий строку с элементами множества
// *и метод позволяющий читать элементы по индексу.
//        *Реализовать все методы из семинара.
//        Формат данных Integer.

package org.example;


import java.util.HashMap;
import java.util.Iterator;

public class MyHashSet<T> {
    private HashMap<T, Object> hashMap = new HashMap<>();
    private static final Object OBJECT = new Object();


    public boolean add(T value) {
        return hashMap.put(value, OBJECT) == OBJECT;
    }

    public boolean remove(T value) {
        return hashMap.remove(value) == OBJECT;
    }

    public Integer size() {
        return hashMap.size();
    }

    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    public Iterator<T> iterator() {
        return hashMap.keySet().iterator();
    }

    public void clear() {
        hashMap.clear();
    }

    public Object[] get() {
        return hashMap.keySet().toArray();
    }
}
