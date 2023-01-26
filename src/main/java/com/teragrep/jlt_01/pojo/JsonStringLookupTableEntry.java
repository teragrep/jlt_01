package com.teragrep.jlt_01.pojo;

public class JsonStringLookupTableEntry {
    final String index;
    final String value;

    public JsonStringLookupTableEntry(String index, String value) {
        this.index = index;
        this.value = value;
    }

    public String getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "JsonStringLookupTableEntry{" +
                "index='" + index + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
