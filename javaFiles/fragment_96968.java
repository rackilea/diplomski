for(int i = 0; i < n; i++)   //<---- cost A*n^2 time
    {
        for(int j = 0; j < n; j++) 
        {
            if ( i == j ) 
                continue;

            if (strings[i] == strings[j])
                count++;
        }
    } 
    return count;  //<---- cost constant time