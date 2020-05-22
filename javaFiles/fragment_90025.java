package com.github.xsavikx.jackson;

import java.util.Map;

public class DatabaseEntry {
    private String action;
    private Map<String, DatabaseRow> data;

    public DatabaseEntry() {

    }

    public DatabaseEntry(String action, Map<String, DatabaseRow> data) {
        this.action = action;
        this.data = data;
    }

    public Map<String, DatabaseRow> getData() {

        return data;
    }

    public void setData(Map<String, DatabaseRow> data) {
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

package com.github.xsavikx.jackson;

public class DatabaseRow {
    private int weekNumber;
    private String someData;
    public DatabaseRow(){
    }
    public DatabaseRow(int weekNumber, String someData) {
        this.weekNumber = weekNumber;
        this.someData = someData;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getSomeData() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }
}