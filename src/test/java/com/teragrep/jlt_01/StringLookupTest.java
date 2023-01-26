/*
 * Java LookupTable Library JLT-01
 * Copyright (C) 2023 Suomen Kanuuna Oy
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://github.com/teragrep/teragrep/blob/main/LICENSE>.
 *
 *
 * Additional permission under GNU Affero General Public License version 3
 * section 7
 *
 * If you modify this Program, or any covered work, by linking or combining it
 * with other code, such other code is not for that reason alone subject to any
 * of the requirements of the GNU Affero GPL version 3 as long as this Program
 * is the same Program as licensed from Suomen Kanuuna Oy without any additional
 * modifications.
 *
 * Supplemented terms under GNU Affero General Public License version 3
 * section 7
 *
 * Origin of the software must be attributed to Suomen Kanuuna Oy. Any modified
 * versions must be marked as "Modified version of" The Program.
 *
 * Names of the licensors and authors may not be used for publicity purposes.
 *
 * No rights are granted for use of trade names, trademarks, or service marks
 * which are in The Program if any.
 *
 * Licensee must indemnify licensors and authors for any liability that these
 * contractual assumptions impose on licensors and authors.
 *
 * To the extent this program is licensed as part of the Commercial versions of
 * Teragrep, the applicable Commercial License may apply to this file if you as
 * a licensee so wish it.
 */
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

