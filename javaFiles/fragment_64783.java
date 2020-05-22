import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Test {

    public static void main(String[] args) {
        try {

            PrintWriter writer = new PrintWriter(new File(
                    "../Test/src/com/hello2.txt"));

            Scanner scanner = new Scanner(new File("../Test/src/com/hello.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine()+"\n";
                System.out.println(line);
                writer.write(line);
            }

            System.out.println("last line in the text document");
            writer.write("last line in the text document.");
            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}