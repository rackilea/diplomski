public class MatrixAdv
{
    public static void main(String args[])
    {
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Please enter size of element...");
        //int n = sc.nextInt(); // stores size of Matrix
        int n = 9;

        int value = 0;// To be incremented everytime to get the Pattern
        int[][] matrix = new int[n][n];

        matrix[n/2][n/2] = 1;
        int maxValue = ((n / 2) * 4) + 1; 
        int r = n / 2 - 1;
        int c = n / 2 - 1;
        int d = 2;
        for (value=2; value<=maxValue; value++)
        {
            matrix[r][c] = value;
            int step = ((value-2)%4);
            switch (step)
            {
                case 0: c+=d; break;
                case 1: r+=d; c-=d; break;
                case 2: c+=d; break;
                case 3: d+=2; r-=d-1; c-=d-1; break;
            }
        }

        // Display the value in matrix form
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == 0)
                {
                    System.out.printf("%3s", "_");
                }
                else
                {
                    System.out.printf("%3d", matrix[i][j]);
                }
            }
            System.out.print("\n");
        }

    }
}