public static BigInteger makeSparseInt()
{
    BigInteger b = BigInteger.ZERO.setBit(1000000);

    Random r = new Random();

    for (int i = 0; i < 100; i++)
    {
        b = b.setBit(r.nextInt(1000000));
    }
    return b;
}