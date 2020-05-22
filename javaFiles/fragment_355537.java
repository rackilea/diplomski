import java.util.*;

public class duplicate {

   private static TreeSet<Integer> numbers = new TreeSet<Integer>();
   private static TreeSet<Integer> duplicates = new TreeSet<Integer>();

   public static void main (String[] args) {
      Scanner input = new Scanner(System.in);
      int n=0;
      int numberOfIntToRead=10;

      for (int i = 0; i < numberOfIntToRead; i++) {
          // Read number from console
          n=input.nextInt();
          // Check if number was inserted before
          checkIfDuplicate(n);
      }

      // Print all numbers that were not inserted more than one time
      for (Integer j : numbers) {
          System.out.print(j+" ");
      }
   }


   public static void checkIfDuplicate(int n){
      if(!numbers.contains(n) && !duplicates.contains(n)){
         numbers.add(n);
      }else{
         numbers.remove(n);
         duplicates.add(n);
      }
   }

}