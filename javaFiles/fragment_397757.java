import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayReverse {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in); // scanner for input
    final List<Integer> numbers = new ArrayList<>();
    System.out.println("Enter any number of integers. (whitespace delimited. enter a non-integer to quit.): ");
    while (scnr.hasNextBigInteger()) {
      final int n = scnr.nextInt();
      System.out.println("Parsed: " + n);
      numbers.add(n);
    }
    System.out.println("Done reading user input.");
    System.out.println("Your input: " + numbers);
    Collections.reverse(numbers);
    System.out.println("Your input reversed: " + numbers);
  }
}