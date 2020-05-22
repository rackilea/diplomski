package com.stackoverflow;

public class JVMTICallback {

    public static void VMInit() {

        System.out.println("Java:\tJVMTI callback class, VMInit().");

    }

    public static void main(String[] args) {
        // This main is only here to give us something to run for the test

        System.out.println("Java:\tAnd Finally... Hello, I'm the Java main");
    }

}