import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                Scanner lineScanner = new Scanner(fileScanner.nextLine());
                while (lineScanner.hasNext()) {
                    if (lineScanner.hasNextDouble()) {
                        System.out.println("First Double :" + lineScanner.nextDouble());
                        break;
                    } else {
                        lineScanner.next();
                    }
                }
                lineScanner.close();
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}