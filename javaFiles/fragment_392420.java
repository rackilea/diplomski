/* Author: Collin Walsh
Date: 10/15/2019
File name: NstedIfs.java
*/

import java.util.Scanner;

public class NestedIfs {

    // main
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double outsideTempF;

        System.out.println("What is the temperature outside? Input a value and press enter ");

        outsideTempF = keyboard.nextDouble();

        Scanner input = new Scanner(System.in);

        int raining = 0;

        System.out.println("If it is raining, enter the number 1. Then press enter");

        raining = keyboard.nextInt();

        // indicate what clothing to wear, based on temp
        if (outsideTempF > 70) {
            if (raining == 1) {
                System.out.println("Wear t-shirt, shorts, sandals, and an unbrella");
            } else {
                System.out.println("Wear t-shirt, shorts, and sandals.");
            }
        } else if (outsideTempF <= 30) {
            if (raining == 1) {
                System.out.println("Wear boots, pants, raincoat, and gloves.");
            } else {
                // for any temperature beolow 30
                System.out.println("Wear boots, pants, sweater, and gloves.");
            }
        } else {
            if (raining == 1) {
                System.out.println("Wear long-sleeve shirt, pants, a raincoat, and shoes");
            } else {
                System.out.println("Wear long-sleeve shirt, pants, and shoes");

            }
        }
    }
}