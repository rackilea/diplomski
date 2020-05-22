import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter 3 letters");

        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[a-zA-Z]$");

        int total = 0;

        for (int i = 0; i < 3; i++) {
            String input = scanner.nextLine();

            while (!pattern.matcher(input).matches()) {
                System.out.println("You must enter a letter");
                input = scanner.nextLine();
            }

            int letter = input.charAt(0);

            if (letter >= 97 && letter <= 122) {
                total += letter - 96;
            } else if (letter >= 65 && letter <= 90) {
                total += letter + 36;
            }
        }

        if (total % 5 == 0) {
            System.out.println("Password unlocked");
        } else {
            System.out.println("Incorrect password");
        }
    }
}