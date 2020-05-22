for(int i = 0; i < n; i++)
    for(int j = 0; j < n; j++)    // Go through all possible sources and targets

        for(int k = 0; d[i][j] != -INF && k < n; k++)
            if( d[i][k] != INF && // Is there any path from i to k?
                d[k][j] != INF && // Is there any path from k to j?
                d[k][k] < 0)      // Is k part of a negative loop?

                d[i][j] = -INF;   // If all the above are true
                                  // then the path from i to k is undefined