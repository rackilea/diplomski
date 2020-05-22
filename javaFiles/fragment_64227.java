import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;
import javax.swing.JApplet;

public class bitmaps extends JApplet {

    public void init(int[][] numArray) {
        getContentPane().setBackground(Color.red);
    }

//This function reads from a bitmap file and stores the characters (0s and 1s) into arrayLists
    public static int[][] getBits() {
        File bitmap;
        Scanner reader;
        int[][] numArray = new int[20][10];

        try {
            bitmap = new File("bitmap.bmp");
            reader = new Scanner(bitmap);

            int row = 0;
            int column = 0;

            String readStrings = "";

            //While there is more stuff in the file
            while (reader.hasNextLine()) {
                readStrings = reader.nextLine();

                //Run through each line, grab strings, turn into char arrays, turn those into integers and add them to numArray
                for (column = 0; column < readStrings.toCharArray().length; column++) {
                    numArray[row][column] = Character.getNumericValue(readStrings.toCharArray()[column]);
                }

                //Assign all other values that haven't been assigned yet to 0
                for (column = column; column < 10; column++) {
                    numArray[row][column] = 0;
                }
                row++;
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return all of the 1s and 0s
        return numArray;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);

        int[][] numArray = getBits();

        int row = 0;
        int column = 0;

        for (row = 0; row < 20; row++) {
            for (column = 0; column < 10; column++) {
                //If it's a 0, make it a blue rectangle
                //If it's a 1, make it a black rectangle
                //Else, make it a yellow rectangle (never had this problem yet)
                if (numArray[row][column] == 1) {
                    g.setColor(Color.blue);
                } else if (numArray[row][column] == 0) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.yellow);
                }

                //Draw the rectangle
                g.fillRect(column * 10, row * 10, 10, 10);
            }
        }
    }

//  public static void main(String[] args) {
//      int[][] numArray = getBits();
//
//      //Print out the array (output of this is in the question)
//      for (int row = 0; row < 20; row++) {
//          for (int column = 0; column < 10; column++) {
//              System.out.print(String.valueOf(numArray[row][column]) + " ");
//          }
//          System.out.println("");
//      }
//  }
}