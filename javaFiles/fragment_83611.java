package com.github.francipvb.holamundo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var sb = new StringBuilder()
            // The append method returns the builder itself...
            .append("str")
            .append("another str")
            .toString(); // this is the last call.
        System.out.println(sb); // sb is a string
    }
}