import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteToFile {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter n to finish");
        String text = "";
        while (!text.equals("n")) {
            System.out.println("enter first name");
            text = scanner.next();
            pw.write(text + ",");
            System.out.println("enter last name");
            text = scanner.next();
            pw.write(text + ",");
            System.out.println("enter sex");
            text = scanner.next();
            pw.write(text);
            //add more fields
            //finally
            pw.println();
            System.out.println("Continue?");
            text = scanner.next();
        }
        pw.close();
        System.out.println("completed");
    }
}