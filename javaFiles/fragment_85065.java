import java.util.Scanner;

public class AuthoringAssistant {

    private static Scanner scan = new Scanner(System.in);

    public static String scnrMethod() {
        String userInput = scan.nextLine(); // userInput scans for text
        return userInput;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a sample text:");
        String input = scnrMethod();
        System.out.println("You entered: " + input);

        char menuChoice = printMenu();

        boolean t = true;

        if (menuChoice == 'q') {
            System.exit(0);
        }
        else {
            t = false;
        }
        if (t != true) {
            System.out.print("Input an option: " + menuChoice);
        }

    }

    public static char printMenu() {// provides menu for main()

        System.out.println();
        System.out.println("MENU");
        System.out.println("c - Number of non-whitespace characters");
        System.out.println("w - Number of words");
        System.out.println("f - Find text");
        System.out.println("r - Replace all !'s");
        System.out.println("s - Shorten spaces");
        System.out.println("q - Quit\n");

        System.out.println("Choose an option:");
        char menuChoice = scan.nextLine().charAt(0);

        return menuChoice;
    }

}