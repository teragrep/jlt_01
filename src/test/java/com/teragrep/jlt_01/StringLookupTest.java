package com.teragrep.jlt_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StringLookupTest {

    @Test
    public void testLookupLoading() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/good/string.json"));

        StringLookupTable stringLookupTable = new StringLookupTable(bufferedReader);
        Assertions.assertEquals("un", stringLookupTable.lookup("one"));
        Assertions.assertEquals("deux", stringLookupTable.lookup("two"));
        Assertions.assertEquals("trois", stringLookupTable.lookup("three"));
    }
}

