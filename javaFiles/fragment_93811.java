public static BigInteger factorial(int i) {
    BigInteger n = BigInteger.valueOf(i);
    while (--i > 0)
        n = n.multiply(BigInteger.valueOf(i));
    return n;
}