package com.example.test;

import java.util.Arrays;

public class Varargs3 {
    public static Object[] changeLastArgument(Object... objs) {
        if (objs.length > 0)
            objs[objs.length-1] = "Pow!";
        return objs;
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(changeLastArgument(1,2,3))
        );
    }
}