import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    private static void readMatrix(final Scanner scanner, final int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (scanner.hasNextInt()) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }
    }

    private static void displayMatrix(final int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(final String... args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new File("input.txt"));

        final int n1 = scanner.nextInt();
        final int n2 = scanner.nextInt();

        System.out.print(String.format("The matrix is %d x %d \n", n1, n2));

        final int[][] firstMatrix = new int[n1][n2];
        final int[][] secondMatrix = new int[n1][n2];

        System.out.println("Reading data to first matrix");
        readMatrix(scanner, firstMatrix);
        System.out.println("Reading data to second matrix");
        readMatrix(scanner, secondMatrix);

        System.out.println("First Matrix");
        displayMatrix(firstMatrix);
        System.out.println("Second Matrix");
        displayMatrix(secondMatrix);
    }
}