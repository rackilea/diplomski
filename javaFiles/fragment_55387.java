package com.inlet.ifserver;

import java.util.*;

public class x {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        System.out.println("How many numbers in the array?");
        int num = input.nextInt();
        int count1 = 0;

        Integer[] evens = new Integer[num];

        for (int i = 0; i < num; i++) {

            System.out.println("Enter an integer: ");
            int integer = input.nextInt();
            if (integer % 2 == 0)
                evens[count1++] = integer;

        }

        evens = Arrays.copyOfRange(evens, 0, count1);

        System.out.println("There were " + ((double) count1 / num) * 100 + " percent of even numbers.");
        System.out.println("Even values are " + Arrays.toString(evens) + "");


    }
}