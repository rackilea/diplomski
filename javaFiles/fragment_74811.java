static decimal[,] Rotate(decimal[,] input, int k)
    {
        int m = input.GetLength(0);
        int n = input.GetLength(1);
        decimal[,] result = new decimal[m, n];
        for (int i=0; i<m; i++)
        {
            int p = (i + k) % m;
            if (p < 0)
                p += m;
            for (int j=0; j<n; j++)
                result[p, j] = input[i, j];
        return result;
    }