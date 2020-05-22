public static boolean isPrime(int n)
{
       boolean result = true;
       for (int i = 2; n % i == 0 && i < n; i++)
           result = false;
       if (n == 2)
           result = true;
       return result;
}