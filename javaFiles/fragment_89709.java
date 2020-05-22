import java.util.*;
public class Project1 {
    public static void main(String[] args) {
        // creates a new scanner
        Scanner scanner = new Scanner(System.in);

        // rejects input if the first token is not an integer
        System.out.println("Enter the first integer:");
        while(!scanner.hasNextInt()) {
           // scanner.nextLine();
            scanner.next();
            System.out.println("That's not an integer, please enter again:");
        }
        // stores integer in variable when first token is an integer
        int num1 = scanner.nextInt();

        /* ======== repeats for second integer ======== */
        System.out.println("Enter the second integer:");
        while(!scanner.hasNextInt()) {
            //scanner.nextLine();
            scanner.next();
            System.out.println("That's not an integer, please enter again:");
        }
        // stores integer in variable when first token is an integer
        int num2 = scanner.nextInt();

        System.out.println(num1 + num2);
    }
}