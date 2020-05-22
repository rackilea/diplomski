private static int lastDigitDiffZero(long n)
{
   int temp = (int) n;
   int mod = temp%10;

  return (mod == 0 ? lastDigitDiffZero(temp/10) : mod);
}