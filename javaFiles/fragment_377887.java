import java.util.*;
import java.io.*;

public class BabyNames {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("** Popularity of a baby name since year 1920 **");
        System.out.print("name? ");
        String name = console.next();

        Scanner input = new Scanner(new File("names.txt"));
        while (input.hasNext()) {
            String search = input.next();
            if (search.equalsIgnoreCase(name)) { 
                // Do something...    
            }
        }
    }
}