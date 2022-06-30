package com.frotscher.training.exercise;

import org.junit.Test;

import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;

public class LambdaExercise2 {

    @FunctionalInterface
    public interface TwoStringPredicate {
        boolean test(String s1, String s2);
    }


    String betterString(String s1, String s2, TwoStringPredicate predicate) {
        return predicate.test(s1, s2) ? s1 : s2;
    }

    String betterString2(String s1, String s2, BiFunction<String, String, Boolean> predicate) {
        return predicate.apply(s1, s2) ? s1 : s2;
    }


    @Test
    public void test() {
        String string1 = "Hallo";
        String string2 = "Java";

        assertEquals(string1, betterString2(string1, string2, (s1, s2) -> s1.length() > s2.length()));
        assertEquals(string2, betterString2(string1, string2, (s1, s2) -> s1.length() < s2.length()));
        assertEquals(string1, betterString2(string1, string2, (s1, s2) -> true));
        assertEquals(string2, betterString2(string1, string2, (s1, s2) -> false));
    }
}
