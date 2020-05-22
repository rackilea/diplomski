random.nextBytes(bytes);
BigInteger big = new BigInteger(bytes).abs();
BigInteger bigC = BigInteger.valueOf(c);
for (int i = 0 ; i != n ; i++) {
    BigInteger[] dr = big.divideAndRemainder(bigC);
    res[i] = alpha.charAt(dr[1].intValue());
    big = dr[0];
}
String result = new String(res);