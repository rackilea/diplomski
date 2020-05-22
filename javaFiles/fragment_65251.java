for (int i = 2, primesFound = 0; primesFound < n; i++)
    {
        boolean isPrime = true;

        for (int j = 2; j < i; j++)
        {
            if (i % j == 0)
            {
                isPrime = false;
                break;
            }
       }
       if (isPrime)
       {
           System.out.println(i);
           primesFound++;
       }
    }