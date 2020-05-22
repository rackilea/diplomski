static int negSum(int[] a)
{
  int sum = 0;
  for(int i=0; i<a.length; i++)
  {
    if(a[i] < 0)
    {
      for(int j=i+1; j<a.length && a[j]>=0; j++)
        sum += a[j];
      break;
    }
  }
  return sum;
}