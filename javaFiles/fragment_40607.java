import java.util.Scanner;
public class Java {
    public static void main (String [] args) {

        Scanner scan = new Scanner(System.in);
        String answer1;
        System.out.println("Do you like Java?");
        answer1 = scan.next();
        if (answer1.equals("yes"))
        System.out.println("Cool ~");
        else
        System.out.println("Ehh...");
    }
}