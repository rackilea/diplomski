/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class SumArrayList 
{
    public static void main (String[] args)
    {
     Scanner in = new Scanner(System.in);

                    ArrayList<Double> list = new ArrayList<>(5);
                    System.out.print("Enter any 5 numbers: ");

                    while (in.hasNextDouble()) {
                        list.add(in.nextDouble());
                        }
                        // print list
                        System.out.println("The list is " + list);  
                        System.out.println(sum(list));
                    }

                    public static double sum(ArrayList<Double> list) 
                    {

                        double total = 0.0;

                        for(int i = 0; i < list.size(); i++){           
                        total += list.get(i);
                        }
                          // print sum
                        System.out.println("and " + total + " is the sum");
                        return total;
                    }
}