import java.io.*;
import java.util.*;

public class addUp
{
   public static void main(String args[]) 
   { 
      Scanner kb = new Scanner(System.in); 
      System.out.print("Enter something like 8 + 33 + 1345 - 137 : "); 
      String s = kb.nextLine( ); 
      Scanner sc = new Scanner(s); 

      //sc.useDelimiter("\\s*"); <-- don't do this
      int sum = sc.nextInt();
      while(sc.hasNext( )) // <-- not hasNextInt
      {
         String operator = sc.next();
         int value = sc.nextInt();

         if(operator.equals("-"))
         {
            sum = sum - value;
         }

         else if(operator.equals("+"))
         {
            sum = sum + value;
         }
      } 
      System.out.println("Sum is: " + sum); 
   } 
}