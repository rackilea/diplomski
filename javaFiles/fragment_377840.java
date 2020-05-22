public static double harmonicSum(int i)
{
  if(i < 0)
     throw new IllegalArgumentException("i must be positive.");
  if(i == 0)
     return 0;
  return 1.0 / (double)i + harmonicSum(i - 1);
}