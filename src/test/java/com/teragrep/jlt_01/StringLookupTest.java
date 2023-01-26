package com.teragrep.jlt_01;

import com.google.gson.JsonSyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StringLookupTest {

    @Test
    public void stringTable() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/good/string.json"));

        StringLookupTable stringLookupTable = new StringLookupTable(bufferedReader);
        Assertions.assertEquals("un", stringLookupTable.lookup("one"));
        Assertions.assertEquals("deux", stringLookupTable.lookup("two"));
        Assertions.assertEquals("trois", stringLookupTable.lookup("three"));
    }
    @Test
    public void stringTableNoMatch() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/good/string.json"));

        StringLookupTable stringLookupTable = new StringLookupTable(bufferedReader);

        Assertions.assertEquals("unknown", stringLookupTable.lookup("not-there-at-all"));
    }

    @Test
    public void tableNull() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/bad/table_null.json"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringLookupTable stringLookupTable = new StringLookupTable(bufferedReader);
        });
    }

    @Test
    public void notJson() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/bad/not_json.json"));

        Assertions.assertThrows(JsonSyntaxException.class, () -> {
            StringLookupTable stringLookupTable = new StringLookupTable(bufferedReader);
        });
    }

    @Test
    public void nomatchMissing() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/bad/nomatch_missing.json"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringLookupTable stringLookupTable = new StringLookupTable(bufferedReader);
        });
    }

    @Test
    public void valueArray() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/bad/value_array.json"));

        Assertions.assertThrows(JsonSyntaxException.class, () -> {
            StringLookupTable stringLookupTable = new StringLookupTable(bufferedReader);
        });
    }

    @Test
    public void valueObject() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/bad/value_object.json"));

        Assertions.assertThrows(JsonSyntaxException.class, () -> {
            StringLookupTable stringLookupTable = new StringLookupTable(bufferedReader);
        });
    }

    @Test
    public void stringTableEmpty() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/good/string_empty.json"));

        StringLookupTable stringLookupTable = new StringLookupTable(bufferedReader);

        Assertions.assertEquals("unknown", stringLookupTable.lookup("not-a-thing"));
    }
}

