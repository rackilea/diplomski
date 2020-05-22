public class Matrixer
{

    final double[][] matrix, computedMatrix;
    final int rows, cols;

    public Matrixer(int N, int M, final double[][] imatrix)
    {
        rows = N;
        cols = M;
        matrix = imatrix;
        computedMatrix = new double[N][M];
    }

    public void computeAverages()
    {
        for (int i = 1; i < rows - 1; i++)
        {
            for (int j = 1; j < cols - 1; j++)
            {
                computedMatrix[i][j] = cellNeighborsAverage(i, j);
            }
        }
    }

    private double cellNeighborsAverage(int row, int col)
    {
        // Ignore center cell
        double sum = matrix[row - 1][col - 1] + matrix[row - 1][col]
                + matrix[row - 1][col + 1] + matrix[row][col - 1]
                + matrix[row][col + 1] + matrix[row + 1][col - 1]
                + matrix[row + 1][col] + matrix[row + 1][col + 1];
        return sum / 8;
    }

    public void printComputedMatrix()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.printf("%.2f", computedMatrix[i][j]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        final double[][] matrix =
        {
            {1, 2, 3, 4, 5},
            {5, 4, 3, 5, 1},
            {3, 2, 2, 3, 4},
            {2, 3, 4, 5, 3},
            {3, 2, 4, 5, 6},
        };

        Matrixer mx = new Matrixer(5, 5, matrix);
        mx.computeAverages();
        mx.printComputedMatrix();
    }
}