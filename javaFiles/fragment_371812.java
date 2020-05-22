package com.example.string;

public class StringExample {

    public static int indexOf(String str, String search, int fromIndex) {
        if (fromIndex < 0) {
            fromIndex = str.length() + fromIndex; // convert the negative index to a positive index, treating the negative index -1 as the index of the last character
            int index = str.lastIndexOf(search, fromIndex);
            if (index == -1) {
                index = Integer.MIN_VALUE; // String.indexOf normally returns -1 if the character is not found, but we need to define a new contract since -1 is a valid index for our new implementation
            }
            else {
                index = -(str.length() - index); // convert the result to a negative index--again, -1 is the index of the last character 
            }
            return index;
        }
        else {
            return str.indexOf(str, fromIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println(indexOf("abcd", "d", -1)); // returns -1
        System.out.println(indexOf("adbcd", "d", -2)); // returns -4
    }
}