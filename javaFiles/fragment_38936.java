for (int n = min / x; n <= min (N, (max + count) / x); n++)
{
    for (int j = max (0, x * n - max); j <= min (count, x * n - min, n); j++)
    {
        sum = x * n - j;
        if (sum >= min && sum <= max)
        {
            output1 = n;
        }
    }
}