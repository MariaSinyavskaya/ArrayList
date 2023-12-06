package org.example;

import org.example.impl.StringListImpl;
import org.example.interfaces.StringList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        StringList otherStringList = new StringListImpl();

        stringList.add("one");
        stringList.add("two");
        stringList.add("four");
        stringList.add(2,"three");

        System.out.println(Arrays.toString(stringList.toArray()));

        stringList.add("six");
        stringList.set(4, "five");

        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println(stringList.get(3));

        System.out.println(stringList.indexOf("two"));

        System.out.println(stringList.lastIndexOf("four"));

        System.out.println(stringList.isEmpty());

        otherStringList.add("1");
        otherStringList.add("2");
        otherStringList.add("3");
        System.out.println(Arrays.toString(otherStringList.toArray()));

        System.out.println(stringList.equals(otherStringList));

        stringList.remove("one");
        System.out.println(Arrays.toString(stringList.toArray()));
    }
}