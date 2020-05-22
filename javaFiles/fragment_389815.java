//here is comments in java
package help;

import java.util.Scanner;
//this is the way how you can all the libraries in java so
/*
#include<stdio.h>
#include<stdlib.h>
#include<graphics.h>
*/    

//here name of your class
public class Help {

    //here name of your methode
    public static void printbin(int num) {
        int binnum;
        binnum = num % 2;
        num = num / 2;
        if (num != 0) {
            printbin(num);
        }
        System.out.println(binnum);
    }

    //here is the main methode in java
    public static void main(String args[]) {
        int posnumber, binnum;
        Scanner scan = new Scanner(System.in);
        System.out.println("Give a number : ");
        posnumber = scan.nextInt();
        System.out.println(posnumber);
    }
}