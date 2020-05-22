package com.abhinav.testing;

import java.io.*;
import java.util.*;

class largestLoop
{   
public static void main(String [] args) throws IOException
{
    String name;
    int[] num = new int[4]; // save 4 number in array
    int smallest=0,largest=0;
    int count=0;
    do{
        count++;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name : ");
        name = stdin.readLine();
        System.out.println(name + ", Please enter 4 numbers");

        // Read for number using for loop
        Scanner inData = new Scanner(System.in);
        for(int i = 0; i < num.length; i++)
        {
            System.out.print("Enter " + (i+1) + " : "); // value i will + 1 
            num[i] = inData.nextInt();
        }
        smallest = num[0];
        largest = num[0];
        // Find larger and smallest 
        for (int i : num) 
        {
            if (i < smallest) 
            {
                smallest = i;
            } // end finding smallest
            else if (i > largest) 
            {
                largest = i;
            } // end finding largest number 
        } // end finding largest and smallest values
        System.out.println("Largest = " + largest);
        System.out.println("Smallest = " + smallest);
    }while(largest >= 10);
    System.out.println("Number of times the loop ran= "+count);
}
}