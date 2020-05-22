static void available(int[] arr, int min, int max)
{
  for (int j=0, i=0; j<=max; j=arr[i]+1, i++)
  {
    if (j >= min && (i==arr.length || j < arr[i]))
      System.out.printf("%d ", j);
    if(i == arr.length) break;
  }
  System.out.println("\n");
}