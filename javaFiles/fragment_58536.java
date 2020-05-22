public static BigInteger factorial(int n) {
    BigInteger result = BigInteger.ONE;
    for (int i = 2; i <= n; i++) { // <-- n, not 100.also, x*1=x
        result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
}