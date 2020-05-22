import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        convertString();
    }

    private static String[] userInput() {
        Scanner myUserInput = new Scanner(System.in);
        String[] inPutList = new String[3];

        for (int i = 0; i <= 2; i++) {
            System.out.print("Please enter a letter of the alphabet: ");
            inPutList[i] = myUserInput.nextLine();
            while (!inPutList[i].matches("[A-Za-z]+")) {
                System.out.print("Please enter a letter of the alphabet ony: ");
                inPutList[i] = myUserInput.nextLine();
            }
        }
        System.out.println("You have entered: " + Arrays.toString(inPutList));
        return inPutList;
    }

    private static void convertString() {
        String[] storedInput = userInput();
        System.out.println(Arrays.toString(storedInput));
    }
}