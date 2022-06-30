package com.frotscher.training.exercise;

import com.frotscher.training.Car;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LambdaExercise3 {

    @FunctionalInterface
    public interface TwoElementPredicate<T> {
        boolean test(T element1, T element2);
    }

    <T> T betterElement(T s1, T s2, TwoElementPredicate<T> predicate) {
        return predicate.test(s1, s2) ? s1 : s2;
    }


    @Test
    public void test() {
        String string1 = "Hallo";
        String string2 = "Java";

        assertEquals(string1, betterElement(string1, string2, (s1, s2) -> s1.length() > s2.length()));
        assertEquals(string2, betterElement(string1, string2, (s1, s2) -> s1.length() < s2.length()));
        assertEquals(string1, betterElement(string1, string2, (s1, s2) -> true));
        assertEquals(string2, betterElement(string1, string2, (s1, s2) -> false));


        Car polo = new Car(25000, "Polo");
        Car golf = new Car(30000, "Golf");

        Car cheaperCar = betterElement(polo, golf, (c1, c2) -> c1.price < c2.price);
        assertEquals(polo, cheaperCar);

        Car moreExpensiveCar = betterElement(polo, golf, (c1, c2) -> c1.price > c2.price);
        assertEquals(golf, moreExpensiveCar);
    }
}
