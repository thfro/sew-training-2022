package com.frotscher.training;

public class Person {
    private String name;
    private float salary;

    public Person(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }
}
