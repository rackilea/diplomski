static double getSolution1 (int n)
{
    Double[] w = new Double[n+1];
    w[0] = -1d;
    for (int i = 0; i < n; i++)
    {
        w[i+1] = w[i] + ((2 / 3*n ) * Math.cos (w[i]) );
    }
    return w[n];
}