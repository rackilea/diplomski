package org.example;

import java.util.HashMap;
import java.util.Map;

public class MyClass {

    private static final Map<String, String> COUNTRY_LIST = new HashMap<>();

    static {
        COUNTRY_LIST.put("Spain", "es");
        COUNTRY_LIST.put("USA", "us");
    }

    public static String getCountryCode(String name) {
        return COUNTRY_LIST.get(name);
    }
}