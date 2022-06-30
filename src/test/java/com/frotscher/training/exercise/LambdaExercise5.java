package com.frotscher.training.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LambdaExercise5 {

    public List<String> allMatches(List<String> strings, Predicate<String> predicate) {
        List<String> matches = new ArrayList<>();

        for (String s : strings) {
            if (predicate.test(s)) {
                matches.add(s);
            }
        }

        return matches;
    }

    @Test
    public void testAllMatches() {
        List<String> words = List.of("This", "is", "a", "test", "sentence");

        List<String> shortWords = allMatches(words, s -> s.length() < 4);
        assertEquals(List.of("is", "a"), shortWords);

        List<String> wordsWithB = allMatches(words, s -> s.contains("b"));
        assertEquals(List.of(), wordsWithB);

        List<String> evenLengthWords = allMatches(words, s -> (s.length() % 2) == 0);
        assertEquals(List.of("This", "is", "test", "sentence"), evenLengthWords);
    }



    public <T> List<T> allMatchesGeneric(List<T> list, Predicate<T> predicate) {
        List<T> matches = new ArrayList<>();

        for (T item : list) {
            if (predicate.test(item)) {
                matches.add(item);
            }
        }

        return matches;
    }

    @Test
    public void testAllMatchesGeneric() {
        List<String> words = List.of("This", "is", "a", "test", "sentence");

        List<String> shortWords = allMatches(words, s -> s.length() < 4);
        assertEquals(List.of("is", "a"), shortWords);

        List<String> wordsWithB = allMatches(words, s -> s.contains("b"));
        assertEquals(List.of(), wordsWithB);

        List<String> evenLengthWords = allMatches(words, s -> (s.length() % 2) == 0);
        assertEquals(List.of("This", "is", "test", "sentence"), evenLengthWords);


        List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
        List<Integer> bigNums = allMatchesGeneric(nums, n -> n > 500);
        assertEquals(List.of(1000, 10000), bigNums);
    }



    public static <T, R> List<R> transformedList(List<T> elements, Function<T, R> transformFn) {
        List<R> results = new ArrayList<>();

        for (T element : elements) {
            results.add(transformFn.apply(element));
        }

        return results;
    }

    @Test
    public void test() {
        List<String> words = List.of("This", "is", "a", "test", "sentence");

        List<Integer> wordLengths = transformedList(words, String::length);

        assertEquals(5, wordLengths.size());
        assertEquals(4, (int) wordLengths.get(0));
        assertEquals(2, (int) wordLengths.get(1));
        assertEquals(1, (int) wordLengths.get(2));
        assertEquals(4, (int) wordLengths.get(3));
        assertEquals(8, (int) wordLengths.get(4));
    }

    @Test
    public void testPredicates() {
        Predicate<String> isLongerThan5 = s -> s.length() > 5;
        Predicate<String> isShorterThan10 = s -> s.length() < 10;

        assertTrue(isLongerThan5.and(isShorterThan10).test("ABCDEF"));
        assertFalse(isLongerThan5.and(isShorterThan10).test("ABCDE"));
        assertFalse(isLongerThan5.and(isShorterThan10).test("ABCDEFGHIJKL"));
    }
}