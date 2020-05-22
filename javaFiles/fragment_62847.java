import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String pass,user;
        System.out.print("Username: ");
        user = input.next();
        System.out.print('\f');

        while (true) {
            System.out.print("Pass: ");
            pass = input.next();
            System.out.print('\f');

            System.out.print("Password Again: ");
            String pass2 = input.next();
            System.out.print('\f');

            if (pass.equals(pass2)) {
                System.out.println("*Passwords Match*");
                System.out.println("");
                break;
            } else if (!pass.equals(pass2)) {
                 System.out.println("*Passwords don't match, please try again*");
                 System.out.println("");
            }

        }
        System.out.println("User: " + user);
        System.out.println("Pass: " + pass);
    }
}