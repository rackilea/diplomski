public static void main(String[] args)
{
  int[][] tests = {
      {1,3,4,10},
      {0,1,3,4,10},
      {1,3,4,999},
  };

  for(int[] test : tests) 
  {
    System.out.println(Arrays.toString(test));
    available(test, 0, 999);
  }
}