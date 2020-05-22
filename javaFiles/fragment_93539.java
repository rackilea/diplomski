import java.util.Scanner;

 public class RelativelyPrime {
      public static void main(String[] args) {
          Scanner scnr = new Scanner(System.in);  
          int num1 = scnr.nextInt();
          int num2 = scnr.nextInt();
          System.out.println("Common divisors of " + num1 + " and " + num2 + ":");
          for(int i = 1; i<= Math.min(num1,num2); i++){
            if(num1%i==0 && num2%i==0) {
               System.out.println(i);
            }
          } 
       }
}