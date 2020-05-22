package sandbox2;
import java.util.Scanner;

public class Sandbox2 {
    static Scanner keyboard = new Scanner(System.in); // One instance, available to all methods

    public static void main(String[] args)  {
        for (int i = 0; i < 5; i++) {
            String s = askForProperty("Enter value for " + i + ": ");
            System.out.println(i + " is: " + s);
        }
        keyboard.close(); //Only close after everything is done.
    }

    private static String askForProperty(String message) {
        System.out.print(message);
        String s = keyboard.nextLine();
        return s;
    }
}