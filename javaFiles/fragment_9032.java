private static void findPairs(int input, int[] primes)
{
    String primepairs = "";
    for(int i = 0; i < primes.length; i++)
    {
        for(int j = i; j < primes.length; j++)
        {
            int p = primes[i];
            int q = primes[j];
            if(p+q == input)
            {
                primepairs += "\n" + q + " + " + p + " = " + input;
            }
        }
    }
    System.out.println("\n" + primepairs);
}