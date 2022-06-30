package com.frotscher.training.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RecordExercise {


    @Test
    public void testRecords() {
        Student s1 = new Student(1, "Zfsfds", 20);
        Student s2 = new Student(2, "Mdsfsdf", 21);
        Student s3 = new Student(3, "Csdfsf", 22);

        System.out.println(s1.toString());
        System.out.println(s1.toUpperCase());

        System.out.println(s1.id());
        System.out.println(s1.name());
        System.out.println(s1.age());

        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.sort(null);

        System.out.println(studentList);

        System.out.println(Student.upperCaseName(s1));
    }

    public Student createStudent(String name, Integer age) {
        return new Student(4850, name, age);
    }

}
