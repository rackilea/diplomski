static BigInteger cSelect(int x, int y) {
    BigInteger v = BigInteger.ONE;
    for (int i = x, j = 1; j <= y; i--, j++)
        v = v.multiply(BigInteger.valueOf(i)).divide(BigInteger.valueOf(j));
    return v;
}