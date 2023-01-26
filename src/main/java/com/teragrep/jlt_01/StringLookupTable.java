package com.teragrep.jlt_01;

import com.google.gson.Gson;
import com.teragrep.jlt_01.pojo.JsonStringLookupTable;

import java.io.BufferedReader;
import java.util.HashMap;

public class StringLookupTable {

    private final HashMap<String, String> stringLookup = new HashMap<>();
    public StringLookupTable(BufferedReader bufferedReader) {
        Gson gson = new Gson();

        JsonStringLookupTable lookupTable = gson.fromJson(bufferedReader, JsonStringLookupTable.class);

        for (int i = 0; i < lookupTable.getTable().size(); i++) {
                stringLookup.put(lookupTable.getTable().get(i).getIndex(), lookupTable.getTable().get(i).getValue());
        }
    }
    public String lookup(String expression) {
        return stringLookup.get(expression);
    }
}
