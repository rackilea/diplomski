primes.add(2);
    for(int i=2;i*i<=n;i++)
    {
        isMultiple[2*i]=true;
    }
    for(int i=3;i*i<=n;i+=2)
    {
        if(!isMultiple[i]) 
        {
            primes.add(i);
            for(int j=i*i;j<n;j+=i)
            {
               isMultiple[j]=true;
            }
        }
    }
    return primes;