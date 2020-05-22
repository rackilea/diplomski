import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Scores {

public static void main(String[] args) throws FileNotFoundException {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What is the name of the file containing the scores?");
    String fileName = keyboard.nextLine();
    Scanner fileScan = new Scanner(new File(fileName));

    //TODO: read in the values for the number of students and number of assignments using the Scanner on the file
    //TODO: create a 2-D to store all the scores and read them all in using the Scanner on the file
    int rows = fileScan.nextInt();
    int columns = fileScan.nextInt();

    int[][] myArray = new int[rows][columns];
    while (fileScan.hasNextLine()) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                myArray[i][j] = fileScan.nextInt();
            }
            fileScan.nextLine();
        }
    }
    System.out.println("Array of scores:");
    //TODO: print the entire array, row by row, using Arrays.toString()
    System.out.println(Arrays.deepToString(myArray).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

    System.out.println("Average score of each assignment:");
    //TODO: compute and print the average on each assignment
    double total = 0;
    int assignment = 1;
    for (int i = 0; i < myArray[0].length; i++) {
        for (int j = 0; j < myArray.length; j++) {
            total += myArray[j][i];
        }
        System.out.println("Assignment #" + assignment++ + " Average = " + (total / 3));
        total = 0;
    }
    fileScan.close();
    keyboard.close();
}
}