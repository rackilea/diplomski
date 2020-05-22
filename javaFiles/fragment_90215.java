package com.test;

import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonArray;

public class JArray {

    public static void main(String[] args) {
        JsonArray array1 = new JsonArray();

        array1.addAll(getJsonArrayFromList(Arrays.asList("ex1", "ex2", "ex3")));
        array1.addAll(getJsonArrayFromList(Arrays.asList("ex4", "ex5", "ex6")));

        System.out.println("array1 = " + array1);
    }

    public static JsonArray getJsonArrayFromList(List<String> list) {
        JsonArray array = new JsonArray();
        for (String s : list) {
            array.add(s);
        }
        return array;
    }

}