Random rand = new Random();
BigInteger val = BigInteger.ONE;
for (int i = 0; i < 100; i++) {
    int v = rand.nextInt(301) + 200; // 0-300 + 200, is the range 200-500.
    val = val.multiply(BigInteger.valueOf(v));
    System.out.printf("Random number %d: %d%n", i + 1, v);
}
System.out.println(val);