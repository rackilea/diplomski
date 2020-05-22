int[] indexes = new int[n];
outer: while (true) {
    if (indexes[n-1] == u) {
        int indexesToChange = 1;
        while ((indexesToChange < n + 1) && (indexes[n - indexesToChange] >= (u-1)))
            indexesToChange++;
        if (indexesToChange == n+1)
            break outer;
        indexes[n - indexesToChange]++;
        for (int i = indexesToChange - 1; i > 0; i--)
            indexes[n - i] = indexes[n - indexesToChange];
    } else {
        // do something
        indexes[n-1]++;
    }
}