private static boolean isPrime( int n)
{
    boolean prime = true;

    for (int divisor = 2; divisor <= n; divisor++)
    {          
        for (int i = 2; i < divisor; i++)
        {
            if (isFactor(n, divisor))
            {
               prime =false;
            }
        }
    }
    return prime;
}