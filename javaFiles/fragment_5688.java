package anything.synchronize_stackoverflow_post;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @date 21.11.2012
 * @author Thomas Jahoda
 */
public class MatrixMulti {

    public static void main(String[] args) {
        int[][] matrixA;
        int[][] matrixB;
        int colA = 0;
        int rowA = 0;
        int colB = 0;
        int rowB = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the dimensions of matrix A");

        do {
            System.out.print("column for matrix A: ");
            colA = userInput.nextInt();
            System.out.println();
        } while (!validDimension(colA));

        rowB = colA;

        do {
            System.out.print("row for matrix A: ");
            rowA = userInput.nextInt();
            System.out.println();
        } while (!validDimension(rowA));

        matrixA = new int[rowA][colA];

        System.out.println("Please enter the dimensions of matrix B:");
        do {
            System.out.print("column for matrix B: ");
            colB = userInput.nextInt();
            System.out.println();
        } while (!validDimension(colB));

        matrixB = new int[rowB][colB];


        fillMatrix(matrixA);
        fillMatrix(matrixB);

        System.out.println("Would you like to print out matrix A and B? (y/n)");
        String userResponse = userInput.next();
        if (userResponse.equalsIgnoreCase("y")) {
            System.out.println("Matrix A:");
            printBackMatrix(matrixA);
            System.out.println();
            System.out.println("Matrix B:");
            printBackMatrix(matrixB);
            System.out.println();
        }


        int[][] matrixProduct3 = multMatrixWithThreadsSync(matrixA, matrixB);

        String fileName = "test.txt";
        System.out.println("Matrix product is being written to " + fileName);
        try {
            printMatrixToFile(matrixProduct3, fileName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static int[][] multMatrixWithThreadsSync(int[][] matrixA, int[][] matrixB) {

        int[][] matrixProduct = new int[matrixA.length][matrixB[0].length];
        int[] matrixProductColumn = new int[matrixA.length];
        //
        ConcurrentMatrixMultiplyingTask.ConcurrencyContext context = new ConcurrentMatrixMultiplyingTask.ConcurrencyContext(matrixProduct.length);
        //
        Runnable task = new ConcurrentMatrixMultiplyingTask(context, matrixA, matrixB, matrixProduct);
        Thread[] workers = new Thread[5];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(task, "Worker-"+i);
        }
        for (int i = 0; i < workers.length; i++) {
            Thread worker = workers[i];
            worker.start();
        }
        for (int i = 0; i < workers.length; i++) {
            Thread worker = workers[i];
            try {
                worker.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(MatrixMulti.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return matrixProduct;
    }

    private static void printMatrixToFile(int[][] matrix, String fileName) throws IOException {
        PrintWriter userOutput = new PrintWriter(new FileWriter(fileName));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                userOutput.print(matrix[i][j] + " ");
            }
            userOutput.println();
        }
        userOutput.close();

    }

    private static void printBackMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix) {
        Random rand = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = rand.nextInt(100) + 1;
            }
        }

    }

    public static boolean validDimension(int dim) {
        if (dim <= 0 || dim > 1000) {
            System.err.println("Dimension value entered is not valid");
            return false;
        }
        return true;

    }
}