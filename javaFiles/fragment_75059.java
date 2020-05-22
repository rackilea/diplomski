static List<uint> small_primes_between (uint m, uint n)
{
    m = Math.Max(m, 2);

    if (m > n)
        return new List<uint>();

    Trace.Assert(n - m < int.MaxValue);

    uint sieve_bits = n - m + 1;
    var eliminated = new bool[sieve_bits];

    foreach (uint prime in small_primes_up_to((uint)Math.Sqrt(n)))
    {
        uint start = prime * prime, stride = prime;

        if (start >= m)
            start -= m;
        else
            start = (stride - 1) - (m - start - 1) % stride;

        for (uint j = start; j < sieve_bits; j += stride)
            eliminated[j] = true;
    }

    return remaining_numbers(eliminated, m);
}

//---------------------------------------------------------------------------------------------

static List<uint> remaining_numbers (bool[] eliminated, uint sieve_base)
{
    var result = new List<uint>();

    for (uint i = 0, e = (uint)eliminated.Length; i < e; ++i)
        if (!eliminated[i])
            result.Add(sieve_base + i);

    return result;
}

//---------------------------------------------------------------------------------------------

static List<uint> small_primes_up_to (uint n)
{
    Trace.Assert(n < int.MaxValue);    // size_t is int32_t in .Net (!)

    var eliminated = new bool[n + 1];  // +1 because indexed by numbers

    eliminated[0] = true;
    eliminated[1] = true;

    for (uint i = 2, sqrt_n = (uint)Math.Sqrt(n); i <= sqrt_n; ++i)
        if (!eliminated[i])
            for (uint j = i * i; j <= n; j += i)
                eliminated[j] = true;

    return remaining_numbers(eliminated, 0);
}