package com.frotscher.training.exercise;

import org.junit.Test;

public class TextBlockExercise {

    @Test
    public void testTextBlocks() {
        String block =
            """
             dsfsd\nfsdf  \s\s\s
             sdfsfdsf
            sdfsdfdsf
            "%s"
            """.formatted("Fritz");
        System.out.println(block);

    }
}
