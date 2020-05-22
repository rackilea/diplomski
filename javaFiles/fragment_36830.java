public class Test {

    public static int modulo(int a, int b)
    {
        int r = a % b;

        if(r < 0)
        {
            //System.out.println(a + " % " + b + " = " + r);
            return r + b;
        }

        return r;
    }

    public static void main(String[] args)
    {
        int[] a = {2, -3, 5, 7, -20, 7};
        int[][] dp={{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};

        int r;
        int best = 0;

        boolean canSumToJ = false;

        int m, x, y;

        for(int i = 1 ; i < a.length + 1 ; i++)
        {
            r = modulo(a[i-1], 3);

            for(int j = 0 ; j < 3 ; j++)
            {
                m = modulo(3+j-r, 3);

                canSumToJ = (dp[i-1][m] > 0);

                if(r == j)
                    x = 1;
                else
                    x = 0;

                if(canSumToJ == true)
                    y = 1 + dp[i-1][m];
                else
                    y = 0;

                dp[i][j] = Math.max(x, y);    
            }

            best = Math.max(best, dp[i][0]);
        }

        System.out.println();

        for(int k = 0 ; k < a.length ; k++)
        {
            for(int l = 0 ; l < 3 ; l++)
            {
                System.out.print(dp[k][l]);
            }
            System.out.println();
        }

        System.out.println("best: " + best);

        /*
         # dp
         # => [[0, 0, 0]
         #    ,[0, 0, 1]
         #    ,[1, 0, 2]
         #    ,[0, 3, 2]
         #    ,[3, 1, 4]
         #    ,[5, 4, 2]
         #    ,[3, 6, 5]]
         */
    }
}