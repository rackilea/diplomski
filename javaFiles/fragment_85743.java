package com.tools;

public class RtFileFinder {

    public static String getPath() {
        return Class.class.getResource("Class.class").getPath();
    }

    public static void main(String[] args) {
        System.out.println(RtFileFinder.getPath());
    }
}