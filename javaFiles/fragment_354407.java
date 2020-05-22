import java.util.Scanner;
public class PalindromeEOF
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Enter a number to check if it is a palindrome:");

        while (scanner.hasNextLine())
        {
            String num = scanner.nextLine();
            String reverse = "";

            for ( int i = 0; i<num.length(); i++ )
            {
                reverse = num.charAt(i) + reverse;
            }
            if (num.equals(reverse))
            {
                System.out.println("\nEntered number IS a palindrome.");
            }
            else
            {
                System.out.println("\nEntered number is NOT a palindrome.");
            }
            System.out.println("\nEnter a number to check if it is a palindrome:");

        }
        System.out.println("\nProgram ended on request");
    }
}