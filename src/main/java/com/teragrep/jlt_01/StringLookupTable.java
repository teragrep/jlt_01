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
