import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Project03 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        // Don't need to bulk of Scanner object
        System.out.println("Type E to encrypt a file, or D to decrypt a file");
        String pick = input.nextLine();
        if (pick.toLowerCase().equals("e")) {
            System.out
                    .println("Enter the file path of the text you'd like to encrypt: ");
            File file = new File(input.nextLine());
            Scanner inputFromFile = new Scanner(file);
            String line = inputFromFile.nextLine();
            System.out
                    .println("Enter the offset you would like to use (must be 1-25)");
            int offset = input.nextInt();
            input.nextLine(); // Consume Extra NewLine
            System.out.println("Name the file you would like to output to");
            String textOutput = input.nextLine();

            PrintStream out = new PrintStream(new FileOutputStream(textOutput));
            System.setOut(out);

            System.out.println(CaesarCipher.encode(line, offset)); // This line should be placed after System.setOut(out), to redirect output to the file

            inputFromFile.close();

        } else if (pick.toLowerCase().equals("d")) {
            System.out
                    .println("Enter the file path of the text you'd like to decrypt: ");
            File file = new File(input.nextLine());
            Scanner inputFromFile = new Scanner(file);
            String line = inputFromFile.nextLine();
            System.out
                    .println("Enter the offset you would like to use (must be 1-25)");
            int offset = input.nextInt();
            input.nextLine(); // Consume Extra NewLine
            System.out.println("Name the file you would like to output to");
            String textOutput = input.nextLine();

            PrintStream out = new PrintStream(new FileOutputStream(textOutput));
            System.setOut(out);

            System.out.println(CaesarCipher.decode(line, offset));
            inputFromFile.close();

        } else {
            System.out.println("Something went Wrong");
        }
        input.close();

    }
}