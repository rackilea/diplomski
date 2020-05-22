public static void main(String[] args)
{
  int tests[][] = new int[][] {
    {-1, 2, 3, -4},
    {-3, 5, 6,  8},
    {9, 2, 3, -1},
    {-1, 2, 3, -4, 5},
    {1, -2, 3, -4},
    };

    for(int[] test : tests)
      System.out.printf("%s : % d\n",Arrays.toString(test), negSum(test));
}