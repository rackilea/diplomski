BigInteger s1 = BigInteger.ZERO;
BigInteger s2 = BigInteger.ONE;
BigInteger current = BigInteger.ZERO;

for (int i = 0; i < 10000; i++) {
    current = (s1.add(s2));
    s2 = s1;
    s1 = current;
    System.out.println((i+1) + ". " + current);
}