import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Characters {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        try (Scanner in = new Scanner(new File(inputFileName))) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                int len = line.length();
                int uppercase = 0;
                int lowercase = 0;
                int digits = 0;
                int whitespace = 0;
                int other = 0;

                for (int i = 0; i < len; i++) {
                    char c = line.charAt(i);

                    if (Character.isLowerCase(c)) {
                        lowercase++;
                    } else if (Character.isUpperCase(c)) {
                        uppercase++;
                    } else if (Character.isDigit(c)) {
                        digits++;
                    } else if (Character.isWhitespace(c)) {
                        whitespace++;
                    } else
                        other++;
                }

                System.out.println("Uppercase: " + uppercase);
                System.out.println("Lowercase: " + lowercase);
                System.out.println("Digits: " + digits);
                System.out.println("Whitespace: " + whitespace);
                System.out.println("Other: " + other);
            }
        }

    }
}