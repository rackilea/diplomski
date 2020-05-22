import java.io.*;
import java.util.*;
public class Cake {

    public static void main(String[] args) throws Exception {
        File fileIn = new File("text.txt");
        ArrayList<String> text = new ArrayList<String>();
        Scanner s = new Scanner(fileIn);
        String line;

        while (s.hasNextLine()) {
            line = s.nextLine();

            if(!line.contains("I love cake")){ //If "I love cake" is not in the line
                System.out.println(line); //Then it's ok to print that line
                text.add(line); //And we can add it to the arraylist
            }
        }
        s.close();
    }

}