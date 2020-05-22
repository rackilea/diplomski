public class MatrixCombinations
{
    public static void main(String[] args)
    {
        int cols = 7;
        int rows = 3;
        int count = (int)Math.pow(rows, cols);
        for (int i=0; i<count; i++)
        {
            String s = String.format("%"+cols+"s", 
                Integer.toString(i, rows)).replaceAll(" ", "0");
            int[][] matrix = createMatrix(rows, cols, s);
            System.out.println("Matrix "+i+", string "+s);
            printMatrix(matrix);
        }
    }

    private static int[][] createMatrix(int rows, int cols, String s)
    {
        int result[][] = new int[rows][cols];
        for (int c=0; c<cols; c++)
        {
            int r = s.charAt(c) - '0';
            result[r][c] = 1;
        }
        return result;
    }

    private static void printMatrix(int matrix[][])
    {
        for (int r=0; r<matrix.length; r++)
        {
            for (int c=0; c<matrix[r].length; c++)
            {
                System.out.printf("%2d", matrix[r][c]);
            }
            System.out.println();
        }
    }
}