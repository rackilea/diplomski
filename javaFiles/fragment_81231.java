import java.util.Scanner;

public class EvenOdd {
  public static void main(String[] args) {
    System.out.print("Enter a character or number. Seriously, though, it is meant to be a number, but you can put whatever you want here. If it isn't a number however, you will get an error message.");
    try (Scanner in = new Scanner(System.in)) {
      int n;
      while (true) {
        String input=in.nextLine();
        try {
          n = Integer.parseInt(input);
          break;
        } catch (NumberFormatException e) {
          System.out.println("you did not enter just an integer, please try again");
        }
      }
      if (n % 2 == 0) {
        System.out.println(n + " is even");
      } else {
        System.out.println(n + " is odd");
      }
    }
  }
}