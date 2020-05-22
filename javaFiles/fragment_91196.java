const int min = 1023456789;
const int expected = 1023;

static bool IsPandigital(int n)
{
    if (n >= min)
    {
        int digits = 0;

        for (; n > 0; n /= 10)
        {
            digits |= 1 << (n - ((n / 10) * 10));
        }

        return digits == expected;
    }
    return false;
}