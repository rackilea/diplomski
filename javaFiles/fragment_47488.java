package com.client;

import java.util.*;

public class UpvoteMe {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "Enter username:", 
                "Enter: username", 
                ":Enter username");

        for (String s : list) {
            String[] beforeColon = s.split(":"); 
            System.out.println(s + " -> '" + beforeColon[0] + "'");
        }

    }
}