package test;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Random generator = new Random();
        float smallest, largest;
        int years;
        float[] array = new float[12];

        smallest = Integer.MAX_VALUE;
        largest = Integer.MIN_VALUE;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter desired years: ");
        years = keyboard.nextInt();

        for (int i = 1; i <= years; i++) {
            System.out.println("Year " + i);
            for (int month = 1; month <= array.length; month++) {
                array[i] = generator.nextFloat() * 100;
                System.out.println("Month " + month + ": " + array[i]);
                if (array[i] < smallest)
                    smallest = array[i];
                if (array[i] > largest)
                    largest = array[i];

            }
            System.out.println("Max = " + largest);
            System.out.println("Min = " + smallest);

            // HERE
            // Reset largest and smallest
            largest = Integer.MIN_VALUE;
            smallest = Integer.MAX_VALUE;
        }
    }
}