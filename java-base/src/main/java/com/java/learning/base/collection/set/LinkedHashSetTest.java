package com.java.learning.base.collection.set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

    public static void main(String[] args) {
        test();
    }

    static void test() {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("abc");
        set.add("efg");
        set.add("abb");

        System.out.println(set);
    }
}
