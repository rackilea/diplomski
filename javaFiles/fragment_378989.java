import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class numWords {
    public static void main(String[] args) throws FileNotFoundException {
    File file = new File("words.txt");

    Scanner filescanner = new Scanner(file);
    int numWords = 0;

    while (filescanner.hasNextLine()) {
        String line = filescanner.nextLine(); //pulls in next line
        Scanner linescanner = new Scanner(line); //create new scanner for just this line
        while (linescanner.hasNext()) {
            numWords++; //counts number of words
            linescanner.next(); //goes to the next word if available

        }
        System.out.println(numWords); //prints the number of words
        numWords = 0;  //resets it to 0
        linescanner.close();
    }
    filescanner.close();
}