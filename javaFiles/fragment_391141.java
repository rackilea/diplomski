package com;

import java.util.Scanner;


public class WorkSheet_1  {
    //static int[] num = new int[3];

    public static void main(String[] args) 
    {
        //call for input
        System.out.println("Please Enter a 3-digit number..");
        Scanner in = new Scanner(System.in);
        int[] num = new int[3];
        for(int i = 0; i < num.length; i++){
        int val = in.nextInt();
        num[i] = val;
        }

        System.out.println("The Sum of the numbers is " + sumNums(num));
        System.out.println("The Reverse of the numbers is " + reverseNums(num));

    }



public static int sumNums(int[] num)
{  
    return num[0] + num[1] + num[2];
}

public static int reverseNums(int[] num)
{
    return num[2] + num[1] + num[0]; 
}  

}