public static void main(String... args) {
    BigInteger a = BigInteger.ONE;
    BigInteger b = BigInteger.ONE;
    String last = null;
    try {
        for (long count = 1; ; count++) {
            BigInteger c = a.add(b);
            last = c.toString();
            a = b;
            b = c;
            if (count % 10000 == 0)
                System.out.println("... " + count);
        }
    } catch (Throwable e) {
        System.out.println("The largest value which was calculated was");
        System.out.println(last);
    }
}