package com.java.learning.java8.streamApi;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        Person same = new Person(1, 10, "zhangsan", "中国");
        list.add(same);
        list.add(same);
        list.add(new Person(2, 11, "lisi", "韩国"));
        list.add(new Person(1, 12, "wangwu", "中国"));
        list.add(new Person(2, 13, "xiaohong", "韩国"));

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(10, 11, 12));

        /**
         * 筛选与切片
         */
        System.out.println("***************筛选与切片***************");
        // filter：过滤不满足条件的数据
        System.out.println("##### filter #####");
        list.stream().filter(person -> person.getAge() > 22).forEach(person -> System.out.println(person.getName()));
        list.stream().filter(person -> person.getCountry().equals("中国")).forEach(person -> System.out.println(person.getName()));

        // limit：截断流，使其元素不超过给定对象
        System.out.println("##### limit #####");
        list.stream().limit(2).forEach(r -> System.out.println(r.getName()));

        // skip：跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
        System.out.println("##### limit #####");
        list.stream().skip(3).forEach(r -> System.out.println(r.getName()));

        // distinct：筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        System.out.println("##### distinct #####");
        list.stream().distinct().forEach(r -> System.out.println(r.getName()));

        /**
         * 映射
         */
        System.out.println("***************映射***************");
        // map：将元素映射为一个新的元素，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        System.out.println("##### distinct #####");
        list.stream().map(Person::getName).map(String::toUpperCase).forEach(System.out::println);

        // flatMap：将流中的每个值都换成另一个流，然后把所有流连接成一个流
        stream.flatMap(Collection::stream).forEach(System.out::println);

        /**
         * 排序
         */
        System.out.println("***************排序***************");
        System.out.println("##### sorted 名称降序 #####");
        list.stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName())).forEach(r -> System.out.println(r.getAge()));
        System.out.println("##### sorted 年龄降序 #####");
        list.stream().sorted(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        }).forEach(r -> System.out.println(r.getAge()));

        /**
         * 查找匹配
         */
        Optional<Person> max = list.stream().max(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(max.get().getAge());


        //list.stream().map(r -> r.getAge()).reduce()

    }
}
