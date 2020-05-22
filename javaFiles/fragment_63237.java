import java.util.*;
import java.io.*;

public class Proj5testing {

    public static void main (String[] args) throws IOException {
        // System.out.print(readBoard("life4.txt"));
        // this will just print a referenceId; if you want to print the contents, you need to write a loop to iterate over all the elements

        int[][] board = readBoard("life4.txt");
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] readBoard(String filename) throws IOException {
        int rows = 0;
        String line = "";
        Scanner inFile = new Scanner(new File(filename));
        while(inFile.hasNextLine()) {
            rows++;
            line = inFile.nextLine();
        }

        // int cols = line.split("\\s+").length;
        // assuming that the file has space-separated integers in different lines
        // e.g.
        // 0 0 1 0 1
        // 0 0 0 0 1
        // 1 1 1 1 1
        // since the file doesn't have space-separated integers, updating the answer

        int cols = line.length();
        // assuming that the file has lines in the following format
        // 001001001
        // 110011011

        inFile = new Scanner(new File(filename));
        // this will bring the scanner back to the start of the file

        int[][] grid = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            line = inFile.nextLine();
            for(int k = 0; k < cols; k++){
                grid[i][k] = line.charAt(k) - '0';
            }
        }
        return grid;
    }
}