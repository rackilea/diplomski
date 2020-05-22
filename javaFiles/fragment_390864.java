public static final void printOneIndexes(BigInteger n)
{
    for (int i = 0; i < n.bitLength(); i++)
    {
        if (n.testBit(i))
            System.out.printf(" %d", i);
    }
}