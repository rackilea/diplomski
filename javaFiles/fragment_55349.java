public static void main(String[] args)
{
    int tempMax = 0;
    final int CEILING = 1_000_000;

    for (int j = 1; j < CEILING; ++j)
    {
        tempMax = Math.max(tempMax, collatzLength(j));
    }
    System.out.println(tempMax);
}

static int collatzLength(long n)
{
    long temp = n;

    for (int length = 1;; ++length)
    {
        if (temp == 1)
            return length;
        else if (temp % 2 == 0)
            temp /= 2;
        else
            temp = temp * 3 + 1;
    }
}