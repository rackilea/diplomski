package com.stackoverflow.answers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashExtractor {

    public static void main(String[] args) {
        String strInput = "Buah... Molt bon concert!! #Postconcert #gintonic";
        String strPattern = "(?:\\s|\\A)[##]+([A-Za-z0-9-_]+)";
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(strInput);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}