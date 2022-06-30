package com.frotscher.training.exercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparingInt;

public class LambdaExercise1 {

    @Test
    public void test() {
        String[] strings = {"this", "is", "an", "array", "of", "random", "sample", "strings"};

        Arrays.sort(strings, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.asList(strings));

        Arrays.sort(strings, (s1, s2) -> s2.length() - s1.length());
        System.out.println(Arrays.asList(strings));

        Arrays.sort(strings, (s1, s2) -> s1.compareTo(s2));
        System.out.println(Arrays.asList(strings));

        Arrays.sort(strings, (s1, s2) -> s1.startsWith("o") ? -1 : +1);
        System.out.println(Arrays.asList(strings));

        //////////////////////////////////////////

        Arrays.sort(strings, comparingInt(String::length));
        System.out.println(Arrays.asList(strings));

        Arrays.sort(strings, comparingInt(String::length).reversed());
        System.out.println(Arrays.asList(strings));

        Arrays.sort(strings, Comparator.naturalOrder());
        System.out.println(Arrays.asList(strings));

        Arrays.sort(strings, (s1, s2) -> oWordsFirst(s1, s2));
        Arrays.sort(strings, LambdaExercise1::oWordsFirst);
        System.out.println(Arrays.asList(strings));
    }


    static int oWordsFirst(String s1, String s2) {
        return s1.startsWith("o") ? -1 : +1;
    }
}
