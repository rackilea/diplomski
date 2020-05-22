public static ArrayList<Integer> list = new ArrayList<Integer>();

public static void primeFactors(int n) {
    if (isPrime(n)) 
    {
        list.add(n);
        return;
    }

    int i = 2;
    while (i < n/2)
    {
        if (n % i == 0)
        {
             if (isPrime(i))
             {
                 primeFactors(n/i);
                 list.add(i);
                 return;
             } 
        }
        i++;
    }
    return;
}