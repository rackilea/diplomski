static BigInteger getFib(int n) {
    BigDecimal x1 = new BigDecimal((1 + Math.sqrt(5)) / 2);
    BigDecimal x2 = new BigDecimal((1 - Math.sqrt(5)) / 2);
    return x1.pow(n).subtract(x2.pow(n))
            .divide(new BigDecimal(Math.sqrt(5))).toBigInteger();
}