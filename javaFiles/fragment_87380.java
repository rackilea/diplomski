import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program52 {
    public static void main(String[] args) throws FileNotFoundException {
        String firstName = getName("First name: ");
        String secondName = getName("Second name: ");
    }

    public static String getName(String getUserName) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int count = 0;
        String name = "";
        boolean nameVerified = false;

        while (nameVerified == false) {
            File fileNames = new File("/file.txt");
            Scanner scnr = new Scanner(fileNames);

            System.out.print(getUserName);
            String name1 = in.next();

            while (scnr.hasNextLine()) {

                String line = scnr.nextLine();
                if (line.toLowerCase().startsWith(name1.toLowerCase())) {
                    count++;
                    if (count == 1) {
                        nameVerified = true;
                        System.out.println();
                        name = line.substring(0, line.indexOf(" "));

                        System.out.println(name);
                    }
                }
            }
            if (nameVerified == false) {
                System.out.print("Invalid name.");
            }
        }
        return name;
    }
}