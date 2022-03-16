package com.java.learning.java8.streamApi;

public class Person {

    private int sex;
    private int age;
    private String name;
    private String country;

    public Person(int sex, int age, String name, String country) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.country = country;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
