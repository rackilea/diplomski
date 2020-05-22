package com.mycompany.app;


public class App {

    private static final String GREETING = System.getProperty("greeting", "Hi");

    public static void main(String[] args) {
        int x = 10;
        System.out.println(GREETING);
    }
}