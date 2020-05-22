import java.util.Scanner;

public class Q2 {

    public static void main(String args[]) {
        Scanner keyboardIn = new Scanner(System.in);
        String Fname;
        String Lname;

        System.out.print("Please enter first name: ");
        Fname = keyboardIn.nextLine();

        System.out.print("Please enter last name: ");
        Lname = keyboardIn.nextLine();

        if (Lname.length() > Fname.length()) {
            System.out.println(Lname + " Is longest ");
        } else if (Fname.length() > Lname.length()) {
            System.out.println(Fname + " Is longest ");
        } else {
            // Both are of same length
        }
    }
}