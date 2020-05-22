import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password please.");
        String password = scanner.nextLine();

        boolean validLength = password.length() >= 8;
        boolean hasLetter = password.matches(".*[a-zA-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpace = password.matches(".*\\s.*");

        if (!validLength)
            System.out.println("The password must be at least 8 characters long.");
        else if (!hasLetter)
            System.out.println("The password must contain at least one letter.");
        else if (!hasDigit)
            System.out.println("The password must contain at least one digit.");
        else if (hasSpace)
            System.out.println("The password must not contain spaces.");
        else
            System.out.println("Your password is strong.");
    }
}