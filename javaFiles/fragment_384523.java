import java.util.Scanner;

public class Project{
   static int diff = 0;

   public static int printSequence(int start, int length){
      System.out.println(start);
      for (int i = 1; i <= length; i=i+1){
         start = start + diff;
         System.out.println(start);
      }
      return start;
   }

   public static void main(String[] args){

      Scanner keyboard = new Scanner(System.in);

      diff = (int)(Math.random()*20)+1;
      int term1 = (int)(Math.random()*10)+1;

      int term6 = printSequence(term1, 4) + diff;

      System.out.print("Enter the sixth term of this arithmetic sequence: ");
      int ans = keyboard.nextInt();

      if (ans == term6){
         System.out.println("That is the correct answer.");
      }
      else {
         System.out.println("That is incorrect. Try again.");
      }
   }
}