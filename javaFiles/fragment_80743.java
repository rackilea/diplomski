public static BigInteger factorial(int n) {
    // Try first to use longs in calculating the factorial.

    BigInteger result = BigInteger.ONE;
    long factor = 1;
    for (int i = n; i > 1; --i) {
        if Long.MAX_VALUE / factor < i) { // Overflow?
            result = result.multiply(BigInteger.valueOf(factor));
            factor = i;
        } else {
            factor *= i;
        }
    }
    return result.multiply(BigInteger.valueOf(factor));
}