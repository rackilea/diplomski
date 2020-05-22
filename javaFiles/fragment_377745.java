package com.company;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private String val;

    public Test(String s) {
        this.val = s;
    }

    public static void main(String[] args) {
        List<Test> values = new ArrayList<>();
        values.add(new Test("one"));
        values.add(new Test("two"));
        values.add(new Test("three"));

        System.out.println(listContains(values, "two"));
        System.out.println(listContains(values, "five"));
    }

    public static boolean listContains(List<Test> customTypeList, String searchedString) {
        return customTypeList.stream().anyMatch((v) -> v.val.contains(searchedString));
    }
}