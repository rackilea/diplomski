public static void main(String[] args)
{
    sieve(); // <<== Here
    for (int i=0; i<count; i++)
    {
        if (isPrime[i])
        {
            System.out.println(i + " ");
        }
    }
}