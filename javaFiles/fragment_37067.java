package org.base.api;

public class Activity {
    protected void onCreate(Object obj) {
        System.out.println("onCreate default implementation");
    }

    public boolean onCreateOptionsMenu(Object obj) {
        System.out.println("onCreateOptionsMenu default implementation");
        return false;
    }
}