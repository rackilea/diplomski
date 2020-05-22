package com.samples;

import java.util.Scanner;

public class ScannerSample {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int [] mas = new int[50];

        int inputInt = scanner.nextInt();
        mas[0] = inputInt;

        int count = 1;
        while(inputInt > 0) {
            inputInt = scanner.nextInt();
            if(inputInt > 0)
                mas[count++] = inputInt;
        }
        System.out.println("Exiting now.");
        scanner.close();

        for (int i = 0; i < count; i++) {
            System.out.println(mas[i]);
        }
    }
}