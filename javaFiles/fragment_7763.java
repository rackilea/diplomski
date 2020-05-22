import java.util.Scanner;

    public class MatrixMagic {
        public static void main(String[] args) {
            // Obtain data for first matrix
            Scanner input = new Scanner(System.in);
            System.out.print("Enter matrix1: ");
            double[][] matrix1 = new double[3][3];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++)
                    matrix1[i][j] = input.nextDouble();
            }

            // Obtain data for second matrix
            System.out.print("Enter matrix2: ");
            double[][] matrix2 = new double[3][3];
            for (int i = 0; i < matrix2.length; i++) {
                for (int j = 0; j < matrix2[i].length; j++)
                    matrix2[i][j] = input.nextDouble();
            }

            // Returns result of subtraction
            double[][] subtractResult = subtractMatrices(matrix1, matrix2);

            System.out.println("\nThe matrices are subtracted as follows: ");

            // Print first matrix
            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {
                    System.out.print(matrix1[i][j] + "\t");
                }
                if (i == 1) {
                    System.out.print("    -     ");
                } else {
                    System.out.print("          ");
                }

                // Print second matrix
                for (int j = 0; j < 3; j++) {
                    System.out.print(matrix2[i][j] + "\t");
                }
                if (i == 1) {
                    System.out.print("    =     ");
                } else {
                    System.out.print("          ");
                }

                // Print resultant matrix
                for (int j = 0; j < 3; j++) {
                    System.out.print(subtractResult[i][j] + "\t");
                }
                System.out.println(); // Prints line after each row
            }
        }

        /** Method subtracts one matrix from another */
        public static double[][] subtractMatrices(double[][] a, double[][] b) {
            double[][] subtractResult = new double[3][3];

            for (int i = 0; i < subtractResult.length; i++)
                for (int j = 0; j < subtractResult[i].length; j++) {
                    subtractResult[i][j] = a[i][j] - b[i][j];
                }

            return subtractResult;
        }
    }