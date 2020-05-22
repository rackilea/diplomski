package matrix;

// I know you don't want to use imports, this is simply for testing purposes.
import java.util.Arrays;

public class MatrixAddition
{
    public static void main(String[] args)
    {
        int[][] matrix1 =
        {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
                { 10, 11, 12 } };
        int[][] matrix2 =
        {
                { 1, 1, 1 },
                { 2, 3, 4 } };


        System.out.println("Appending the two matrices results in: ");
        System.out.println(Arrays.deepToString(twoDMatrixAppend(matrix1, matrix2)));
        printMatrix(twoDMatrixAppend(matrix1, matrix2));

        System.out.println("\nPrepending the two matrices results in: ");
        System.out.println(Arrays.deepToString(twoDMatrixPrepend(matrix1, matrix2)));
        printMatrix(twoDMatrixPrepend(matrix1, matrix2));
    }


    private static int[][] twoDMatrixAppend(int[][] matrix1, int[][] matrix2)
    {
        if (matrix1[0].length != matrix2[0].length)
        {
            return null; // Or throw new incompatible matrices exception
        }

        int resultingRowLength = matrix1.length + matrix2.length; // The new length of the resulting matrix

        int[][] result = new int[resultingRowLength][matrix1[0].length];

        int currentRow, col, matrixTwoRowStart;
        for (currentRow = 0; currentRow < matrix1.length; currentRow++)
        {
            for (col = 0; col < matrix1[0].length; col++)
            {
                result[currentRow][col] = matrix1[currentRow][col];
            }
        }

        for (matrixTwoRowStart = 0; matrixTwoRowStart < matrix2.length; matrixTwoRowStart++, currentRow++)
        {
            for (col = 0; col < matrix2[0].length; col++)
            {
                result[currentRow][col] = matrix2[matrixTwoRowStart][col];
            }
        }

        return result;
    }

    private static int[][] twoDMatrixPrepend(int[][] matrix1, int[][] matrix2)
    {
        return twoDMatrixAppend(matrix2, matrix1);
    }

    private static void printMatrix(int[][] arr)
    {
        System.out.println();
        int row, col;
        for (row = 0; row < arr.length; row++)
        {
            for (col = 0; col < arr[0].length; col++)
            {
                System.out.print(String.format("%4d", arr[row][col]));
            }
            System.out.println();
        }
    }

}