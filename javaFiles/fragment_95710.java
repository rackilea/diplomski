import java.awt.*;
import java.io.*;
import java.util.*;

public class Homework {

    public static void main(String[] args) throws FileNotFoundException {       
        // run through the homework

        // read the data (b)
        int[][] array = loadData("sky image.txt");

        // (c) lightSource
        Point light = lightSource(array);
        // check the answer here, is it right?

        // (d) darkSource

        // ... calls, checks for e-g here.

    }

    /** b. Reads the data file “sky image.txt” into the data structure. */
    public static int[][] loadData(string fileName) {
        // your code that is already in main, didn't re-write it just moved it
        File inputFile = new File(fileName);
        Scanner scan = new Scanner(inputFile);
        int dimension1 = scan.nextInt();
        int dimension2 = scan.nextInt();
        int[][] array = new int[dimension1][dimension2];
        while (scan.hasNext()) {
            for (int row = 0; row < dimension1; row++) {
                for (int column = 0; column < dimension2; column++) {
                    array[row][column] = scan.nextInt();
                    System.out.printf("%4d ", array[row][column]);
                }
                System.out.println();
            }

        }
        sc.close();

        return array;
    }

    /** 
     * c. A method called “lightSource” that receives the sky image data and returns the location of the brightest interior spot as a point. 
     * Use Java.awt.Point to represent a point. 
     */
    public static java.awt.Point lightSource( int[][] imageData ) {
        // write code here
        return new java.awt.Point( 0, 0 );
    }


    // put more methods here
}