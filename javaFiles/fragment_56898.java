import java.util.Scanner;

public class ArrayDuplicates 
{

   public static void main(String[] args) 
   {

      Scanner scan = new Scanner(System.in);

      System.out.print("How many numbers are you going to enter? ");
      int num = scan.nextInt();

      int[] arr = new int[num]; // initialize array with user inputted length

      for (int i = 0; i < arr.length; i++)// enter numbers into array
      {

         arr[i] = scan.nextInt();

      }

      double[] unique = new double[arr.length];    //initialize new array that will hold unique values

      ///////My edit

      for(int z = 0; z < unique.length; z++)
      {

         unique[z] = -0.5;

      }

      ///////

      for (int i = 0; i < arr.length; i++) 
      {

         boolean b = true;    //boolean that checks if an element is a duplicate

         for (int j = i+1; j < arr.length; j++)    //check all elements above int i
         {

            if (arr[i] == arr[j]) 
            {

               b = false;    // set b to false if there is an existing duplicate

            }

         }

         if (b) 
         {

            unique[i] = arr[i];    // if no duplicates exist, then it is unique.

         }

      }   

      for (int i = 0; i < unique.length; i++) 
      {

         if(!(unique[i] == -0.5))
         {

            System.out.println((int)(unique[i]));

         }

      }

   }
}