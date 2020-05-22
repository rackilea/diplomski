import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatricesDriver {
    public static void main(String[] args) throws FileNotFoundException {
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Enter name of file: ");
         String filename = keyboard.next();

         List<Problem> problems = readProblems(filename);
         System.out.println(problems);
         keyboard.close();
    }

    private static List<Problem> readProblems(final String filename) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new FileInputStream(filename));
        int numberOfProblems = fileReader.nextInt();
        List<Problem> problems = new ArrayList<>(numberOfProblems);
        for (int i = 1; i <= numberOfProblems; i++) {
            problems.add(readProblem(fileReader));
        }
        fileReader.close();
        return problems;
    }

    private static Problem readProblem(Scanner fileReader) throws FileNotFoundException {
        fileReader.nextLine(); // go to next line
        String operation = fileReader.nextLine(); // read problem operation
        int rows = fileReader.nextInt(); // read number of rows 
        int columns = fileReader.nextInt(); // read number of columns
        Matrix firstMatrix = readMatrix(rows, columns, fileReader);
        Matrix secondMatrix = readMatrix(rows, columns, fileReader);
        return new Problem(operation, firstMatrix, secondMatrix);
    }

    private static Matrix readMatrix(final int rows, final int columns, final Scanner fileReader) throws FileNotFoundException {
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = fileReader.nextInt();
            }
        }
        return new Matrix(result);
    }

}