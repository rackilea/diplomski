import java.util.Scanner;

public class FirstNameLastName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the student's last name: ");
        String lastName = scan.nextLine();

        System.out.println("Please enter the student's first name: ");
        String firstName = scan.nextLine();

        System.out.println("Hello, " + firstName + " " + lastName);
    }
}