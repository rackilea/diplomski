import java.util.Scanner;
   public class Alpha{
   public static void main(String[] args){
         int counter = 0;
         Scanner s= new Scanner(System.in);
         System.out.println("Enter a String :- ");
         String myString=s.nextLine();
            for(char c : myString.toCharArray()) {
               System.out.println(c);
               if("\t".equals(""+c)) {
                 counter = counter + 4;
               } 
               else {
               counter++;
               }
             }
          System.out.println("Counter="+counter);
          }
         }