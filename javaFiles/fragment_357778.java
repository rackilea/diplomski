import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LargestAndSmallest {

  public static void main(String... args) {
    final Scanner keyboard = new Scanner(System.in); //init the scanner
    System.out.println("Enter a number");
    final Set<Integer> ints = new HashSet<>(); //init a set to hold user input
    int n; //declare a variable to hold each number
    while ((n = keyboard.nextInt()) != -99) { //loop until 99 is entered
      ints.add(n); //add user input to our set
      System.out.println("Enter more numbers, or -99 to quit.");
    }
    //output aggregate info
    System.out.println("the largest is " + Collections.max(ints)); 
    System.out.println("the smallest is " + Collections.min(ints));
  }
}