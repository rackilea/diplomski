package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int al = s1.nextInt();
        int a[] = new int[al];
        for (int i = 0; i < al; i++) {
            a[i] = s1.nextInt();
        }

        for (int i = 0, j = al - 1; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        for (int i = 0; i < al; i++) {
            System.out.println(a[i]);
        }
    }
}