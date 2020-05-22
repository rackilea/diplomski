import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainTest {

    public static void main(String args[]) {
      //  if (args[0] != null)
            readFile();
    }

    public static void readFile() { // Method to read file

        Scanner inFile = null;
        String out = "";
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("enter file name");
            String filename = input.next();
            File in = new File(filename); // ask for the file name
            inFile = new Scanner(in);


            int count = 0;
            while (inFile.hasNextLine()) { // reads each line
                String line = inFile.nextLine();


                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    out = out + ch;

                    if (ch == '{') {
                        count = count + 1;
                        out = out + " " + count;
                    } else if (ch == '}') {
                        out = out + " " + count;
                        if (count > 0) {
                            count = count - 1;
                        }
                    }
                }
            }
            System.out.println(out);
        } catch (FileNotFoundException exception) {
            System.out.println("File not found.");
        }
        inFile.close();
    }
}