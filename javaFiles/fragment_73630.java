private void printSumForColumn(int[][] array, int col)
{
  int sum = 0;
  for (int i = 0; i < row; i++)
  {
    sum += array[i][col];
  }
  System.out.println("The sum of column " + col + " is " + sum);
}