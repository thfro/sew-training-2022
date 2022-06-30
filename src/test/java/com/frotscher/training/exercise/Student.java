package com.frotscher.training.exercise;

public record Student (Integer id, String name, Integer age) implements Comparable<Student> {
    public static String upperCaseName(Student s) {
        return s.name.toUpperCase();
    }

    public Student (Integer id, String name, Integer age) {
        if (age < 0) {
            throw new RuntimeException("age muss >= 0 sein");
        }
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public String toUpperCase() {
        return name.toUpperCase();
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}
