import java.util.*;
import java.io.*;
public class InputSum
{

   public static void main (String[] args)
   {

      /******************************************************************************
      *                          Declarations Section                               *
      ******************************************************************************/
      /****************************CONSTANTS********************************/
      Scanner scan = new Scanner(System.in); //Initializes scanner
      int number; //Declare a variable that will hold the temporal value that is read on the input stream      
      int sum=0;

      // Use a List 
      List<Integer> numbers = new ArrayList<Integer>();

      /******************************************************************************
      *                             Inputs Section                                  *
      ******************************************************************************/

      System.out.print("Please input integers, note that -1 ends the submissions: "); //Prompts the user for input

     /****************************variables********************************/
     //***************************Calculations in processing************************//
     /******************************************************************************
      *                             Processing Section                            *
      ******************************************************************************/
      // use an infinite loop
      for(; ; )
      {


         // You should normally do this check when you enter the loop
         // so that -1 which is a stop token should not be added to the list
         // and not taken into account in the sum


         number = scan.nextInt(); //Continues to read numbers and add them to the sum
         if (number == -1){
              break;
         }

         // You could write numbers.add(number) which would be
         // Java's autoboxing feature, but this is what would really take place
         numbers.add(Integer.valueOf(number));
         sum += number; //Calculates the sum


      }
      System.out.print("The numbers entered are: " + numbers);
      System.out.print("\nThe sum of the numbers is: " + sum);

      /******************************************************************************
       *                              Outputs Section                                *
       ******************************************************************************/
       //***************Output is in the processing**************************//
   }
}