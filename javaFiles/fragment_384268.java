package com.company;

public class Generics {
    public <T> T returnAGenericType(T returnThisOne) {
        return returnThisOne;
    }

    public static <T> T returnAGenericTypeStatic(T returnThisOne) {
        return returnThisOne;
    }
}