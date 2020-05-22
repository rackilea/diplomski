package com.java;

import java.util.Scanner;

public class Season4Task7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter X");

        int x = sc.nextInt();

        System.out.println("Enter y");

        int y = sc.nextInt();

        System.out.println("Final :: " + findXPowerY(x, y));

        sc.close();
    }

    static int findXPowerY(int x, int y) {

        if (y == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (y == 1) {
            return x;
        }

        return multiply(x, findXPowerY(x, y - 1));
    }

    static int multiply(int x, int y) {
        if (y != 0)
            return (x + multiply(x, y - 1));
        else
            return 0;
    }
}