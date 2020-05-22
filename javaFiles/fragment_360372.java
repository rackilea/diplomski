public static void main(String[] args) {
    long start = System.nanoTime();
    System.out.println(fib(2000));
    long end = System.nanoTime();
    System.out.println("elapsed:"+ (TimeUnit.NANOSECONDS.toMillis(end - start)) + " ms");
}

private static Map<Integer, BigInteger> cache = new HashMap<Integer, BigInteger>();

public static BigInteger fib(int n) {
    BigInteger bi = cache.get(n);
    if (bi != null) {
        return bi;
    }
    if (n <= 1) {
        return BigInteger.valueOf(n);
    } else {
        bi = fib(n - 1).add(fib(n - 2));
        cache.put(n, bi);
        return bi;
    }
}