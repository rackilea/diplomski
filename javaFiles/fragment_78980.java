public static void main (String[] args)
{
    Scanner input = new Scanner(System.in);

    System.out.println("Enter an odd integer:");

    int n = input.nextInt();

    int[][] magic = new int[n][n];

    // Place 1 in the center of the first row ( row 0)
    int row = 0;
    int col = (n-1)/2;
    magic[row][col] = 1;

    for(int i=2; i <=n*n; i++)
    {
       // Move up and right to a new position
       col = col + 1;
       row = row - 1;
       // row is off the array
       if (row == -1)
           row = n - 1;
       // col is off the array
       if (col == n)
           col = 0;
       // if the place is taken, place the new number under the previous number
       if( magic[row][col] !=0 )
       {
         row = row + 1;
         if (row == n)
           row = 0;
       }

       magic[row][col]=i;
    }

    for(int x = 0; x < n; x++)
    {
      for(int y=0; y < n; y++)
        System.out.print("|"+magic[x][y] +"|\t");
      System.out.println();
    }
}