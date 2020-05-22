import java.util.Scanner;

public class Testing{

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a uncoded string: ");
    String first = input.nextLine();
    input.close();

    if (first.charAt(0) == 'u') {
      first = first.toUpperCase();
    } else if (first.charAt(0) == 'l') {
      first = first.toLowerCase();
    }

    System.out.println("The decoded string is: " + first);
  }
}