import java.util.Random;
import java.util.Scanner;

public class RandomDecimalValue {
    public static void main(String[] args) {
        final int ROW = 3;
        final int COLUMN = 4;
        double scores[][] = new double[ROW][COLUMN];

        Random randGenerator = new Random();
        Scanner sc = new Scanner(System.in);

        // Initialize 2D array with appropriate random decimal values
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                scores[i][j] = (randGenerator.nextDouble() * 99.0) + 1.0;
            }
        }

        // Print out array values
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.printf("%4.1f ", scores[i][j]);
            }
            System.out.println();
        }

        int randomRow = randGenerator.nextInt(ROW);
        int randomCol = randGenerator.nextInt(COLUMN);

        // Get a random decimal value from the 2D array
        System.out.println("\nRandom decimal value: ");
        System.out.printf("%-5.1f%n", scores[randomRow][randomCol]);

        // Prints out random decimal value from selected row/column
        System.out.printf("%nEnter a row number (1-%d): ", ROW);
        int selectedRow = sc.nextInt();
        System.out.printf("Enter a column number (1-%d): ", COLUMN);
        int selectedCol = sc.nextInt();

        if((selectedRow >= 1 && selectedRow <= ROW) &&
                (selectedCol >= 1 && selectedCol <= COLUMN))
        {
            System.out.printf("%nRandom decimal value at Row %d, Column %d: ",
                    selectedRow, selectedCol);
            System.out.printf("%4.1f%n",
                    scores[selectedRow - 1][selectedCol - 1]);
        }
        else
        {
            System.out.println("Invalid row/column values");
        }

        sc.close();
    }
}