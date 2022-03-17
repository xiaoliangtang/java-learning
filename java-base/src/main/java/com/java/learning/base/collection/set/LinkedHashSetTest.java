package com.java.learning.base.collection.set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

    public static void main(String[] args) {
        test();
    }

    static void test() {
//        LinkedHashSet<String> set = new LinkedHashSet<>();
//        set.add("abc");
//        set.add("efg");
//        set.add("abb");
//
//        System.out.println(set);


        String s1 = new String("abcd");
        String s2 = "asdfghjkl";
        int[] num = new int[] {1, 2, 3};
        System.out.println(s1+", "+s2);
        change(s1,s2, num);
        System.out.println(s1+", "+s2 + ", " + num[0]);

    }

    static void change(String s1,String s2, int[] num){
        s1 =new String("12345");
        s2 ="000000";
        num[0] = 10;
        System.out.println(s1+", "+s2 + ", " + num[0]);

    }

}
