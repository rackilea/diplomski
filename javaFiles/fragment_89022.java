import java.util.Scanner;
import java.io.*;
public class squareOutput {

public static void main(String[] args) throws IOException  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter a integer between 1 and 15");
    int number = keyboard.nextInt();
    while (number > 15 || number <1){
        System.out.println("Sorry, thats a invalid number");
        number = keyboard.nextInt();
    }
        keyboard.nextLine();
    keyboard.close();
    FileWriter fwriter = new FileWriter("square.txt", true);
    PrintWriter outputFile = new PrintWriter(fwriter);

        for (int r = 0; r < number; r++)
        {


            for (int c = 0; c < number; c++)
            {
                System.out.print("X");

                outputFile.print("X");
            }
            outputFile.println("");
            System.out.println("");



            // outputFile.close(); <-- NOT HERE
        }
        outputFile.close(); // <-- HERE
    }   
}