package text2nato;
import java.util.Scanner;

public class Text2nato {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the text to convert to nato: ");
    String text = scan.nextLine();

    // You might want to consider converting the whole string to lowercase to make this case-insensitive
    char[] carray = text.toCharArray();

    for(int i=0; i < carray.length; i++){
      if (i > 0)
      {
         // We need to prepend a space here
         System.out.print(" ");
      }
      switch (carray[i])
      {
        case 'a': System.out.print("alpha"); break;
        case 'b': System.out.print("bravo"); break;
        // The rest of your cases go here
        // Be sure to handle the case where the user enters something invalid
        default: System.out.print(carray[i] + " is not a valid lowercase letter"); break;
      }
    }
  }
}