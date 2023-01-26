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

import com.google.gson.Gson;
import com.teragrep.jlt_01.pojo.JsonStringLookupTable;

import java.io.BufferedReader;
import java.util.HashMap;

public class StringLookupTable {

    private final HashMap<String, String> stringLookup = new HashMap<>();
    private final String noMatch;
    public StringLookupTable(BufferedReader bufferedReader) {
        Gson gson = new Gson();

        JsonStringLookupTable lookupTable = gson.fromJson(bufferedReader, JsonStringLookupTable.class);

        if ( lookupTable.getNomatch() == null) {
            throw new  IllegalArgumentException(".nomatch missing");
        }
        else {
            noMatch = lookupTable.getNomatch();
        }

        if ( lookupTable.getTable() == null) {
            throw new IllegalArgumentException(".table missing");
        }
        else {
            for (int i = 0; i < lookupTable.getTable().size(); i++) {
                stringLookup.put(lookupTable.getTable().get(i).getIndex(), lookupTable.getTable().get(i).getValue());
            }
        }
    }
    public String lookup(String expression) {
        String result = stringLookup.get(expression);
        if (result == null) {
            result = noMatch;
        }
        return result;
    }
}
