import java.util.Scanner;
public class Exercise {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        //Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        reverseDisplay(s);
        System.out.println();
    }
    public static void reverseDisplay(String value) {
        //Base case
        if (value.length() < 2) { 
            System.out.print(value);
        } else {
            //Recursion
            //calls for string without first char
            reverseDisplay(value.substring(1));
            //prints first char
            System.out.print(value.charAt(0));
        }
    }
}