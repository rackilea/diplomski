public static BigInteger factorial(int n) {
    BigInteger result = BigInteger.ONE;
    for (; n > 1; n--) {
        result = result.multiply(BigInteger.valueOf(n));
    }
    return result;
}