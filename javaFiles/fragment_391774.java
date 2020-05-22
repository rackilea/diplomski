package com.test;

public class Logger {
    public void logMessage(Object message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        new Logger().logMessage("Hello abc!");
    }
}