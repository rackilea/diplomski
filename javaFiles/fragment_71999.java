package com.stackoverflow;

import java.util.Map;

public class LibPathFinder {
    public static void main(String[] args) {
        String javaLibPath = System.getProperty("java.library.path");
        Map<String, String> envVars = System.getenv();
        System.out.println(envVars.get("Path"));
        System.out.println(javaLibPath);
        for (String var : envVars.keySet()) {
            System.err.println("examining " + var);
            if (envVars.get(var).equals(javaLibPath)) {
                System.out.println(var);
            }
        }
    }
}