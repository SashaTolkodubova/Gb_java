package org.example;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyHashSet<Integer> myHashSet = new MyHashSet<>();
        myHashSet.add(100);
        myHashSet.add(200);
        System.out.println(myHashSet.add(300));
        System.out.println(myHashSet.add(300));
        System.out.println(myHashSet);
        System.out.println(myHashSet.getElementByIndex(10));
        System.out.println(myHashSet.remove(100));
        System.out.println(myHashSet.remove(100));
        System.out.println(myHashSet);
        System.out.println(myHashSet.size());
        System.out.println(myHashSet.isEmpty());
        Iterator<Integer> iterator = myHashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        myHashSet.clear();
        System.out.println(myHashSet.isEmpty());

    }
}
