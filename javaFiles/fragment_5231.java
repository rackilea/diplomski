public MatrixApp(int first[][], int second[][], int m, int n, int p, int q) {
doMatrixMultiply(first, second, m, n, p, q);
}

public void doMatrixMultiply(int first[][], int second[][], int m, int n, int p, int q)
{

   if ( n != p )
      System.out.println("Matrices with entered orders can't be    multiplied with each other.");
   else
   {
      int multiply[][] = new int[m][q];
      int sum = 0;
      for ( int c = 0 ; c < m ; c++ )
      {
         for (int d = 0 ; d < q ; d++ )
         {   
            for (int k = 0 ; k < p ; k++ )
            {
               sum = sum + first[c][k]*second[k][d];
            }

            multiply[c][d] = sum;
            sum = 0;
         }
      }

      System.out.println("Product of entered matrices:-");

      for (int c = 0 ; c < m ; c++ )
      {
         for (int d = 0 ; d < q ; d++ )
            System.out.print(multiply[c][d]+"\t");

             System.out.print("\n");
          }
       }
    }
 }