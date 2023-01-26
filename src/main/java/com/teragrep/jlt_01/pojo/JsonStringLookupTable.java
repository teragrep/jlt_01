package com.teragrep.jlt_01.pojo;

import java.util.List;

public class JsonStringLookupTable {
    final int version;
    final String nomatch;
    final String type;
    final List<JsonStringLookupTableEntry> table;

    public JsonStringLookupTable(int version, String nomatch, String type, List<JsonStringLookupTableEntry> table) {
        this.version = version;
        this.nomatch = nomatch;
        this.type = type;
        this.table = table;
    }

    public int getVersion() {
        return version;
    }

    public String getNomatch() {
        return nomatch;
    }

    public String getType() {
        return type;
    }

    public List<JsonStringLookupTableEntry> getTable() {
        return table;
    }

    @Override
    public String toString() {
        return "JsonStringLookupTable{" +
                "version=" + version +
                ", nomatch='" + nomatch + '\'' +
                ", type='" + type + '\'' +
                ", table=" + table +
                '}';
    }
}
