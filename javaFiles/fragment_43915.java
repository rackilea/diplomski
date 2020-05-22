package com.sandbox;

import java.util.prefs.Preferences;

public class Sandbox {

    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(Sandbox.class);
        Integer counter = Integer.valueOf(prefs.get("counter", "0"));
        System.out.println(counter);
        counter++;
        prefs.put("counter", String.valueOf(counter));
    }
}