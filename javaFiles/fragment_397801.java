import java.io.*;
import java.util.Scanner;


public class TextFile {

    public static void main(String[] args) throws FileNotFoundException {

        if (userPassOk("hello", "world"))
            System.out.println("Welcome");
        else
            System.out.println("Get out!");
    }

    private static boolean userPassOk(String user, String pass)
            throws FileNotFoundException {

        Scanner s = new Scanner(new File("test.txt"));
        while (s.hasNextLine()) {
            String[] userPass = s.nextLine().split(":");
            if (userPass[0].equals(user) && userPass[1].equals(pass))
                return true;
        }
        return false;
    }
}