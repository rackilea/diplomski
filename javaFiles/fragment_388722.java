package com.sandbox;

import java.util.ArrayList;
import java.util.List;

public class Sandbox {

    public static void main(String[] args) {
        ArrayList<String> rawInput = new ArrayList<String>();
        rawInput.add("80");
        rawInput.add("80");
        rawInput.add("60");
        rawInput.add("60");
        new Sandbox().groupBy(rawInput);
    }

    public void groupBy(List<String> rawInput) {
        List<List<String>> output = new ArrayList<>();
        List<String> last = null;

        for (String field : rawInput) {
            if (last == null || !last.get(0).equals(field)) {
                last = new ArrayList<String>();
                last.add(field);
                output.add(last);
            } else {
                last.add(field);
            }
        }

        for (List<String> strings : output) {
            System.out.println(strings);
        }
    }
}