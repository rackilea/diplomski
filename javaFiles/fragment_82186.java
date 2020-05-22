import java.util.*;

public class Main {

  public static void main(String[] args) {
     double numbers[] = new double[5];

     boolean done = false;
     java.util.Scanner sc = new java.util.Scanner(System.in);

     System.out.println("\tFind the min value ");
     System.out.println();

     while(!done) {
         try {
            System.out.println("Enter 5 double numbers:");

            for(int i = 0; i < numbers.length; i++) {
                numbers[i] = sc.nextDouble();
                System.out.println();

                if (numbers[i] < 0) throw new InputMismatchException();
                done = true;
            }
         } catch(InputMismatchException e) {
              System.out.println("");
              System.out.println("Error, enter a number greater than 0");
              sc.nextLine();
              System.out.println("");
         }
     }
     System.out.println("The min value is " +min(numbers)+ ".");
     System.out.println();
  }

  public static double min(double[] array) {
      double min = array[0];

      for(int i = 1; i < array.length; i++) {
         if (array[i] < min)
         min = array[i];
      }

      return min;
  }
}