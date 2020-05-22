import java.util.Scanner;
public class Problem5 {
   public static void main(String[] args){

   int n, i =1;
   Scanner kbd = new Scanner(System.in);

   System.out.print("Enter n: ");
   n = kbd.nextInt();

   while (n <= 0) {
      System.out.print("Enter n: ");
       n = kbd.nextInt();
   }
   int result = 1;
   for (i = 1; i <= n; i++){
      System.out.print( i+ "*");
      result *= i;
   }

   System.out.print(" is " + result);

   }
}