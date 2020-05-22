public string concatenated_factors (int n)
{
    StringBuilder result = new StringBuilder();

    for (int i = 2; i * i <= n; ++i)
        for ( ; n % i == 0; n /= i)
            result.append(Integer.toString(i));

    if (n != 1)
        result.append(Integer.toString(n));

    return result.toString();
}