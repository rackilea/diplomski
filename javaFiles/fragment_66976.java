BigDecimal pi = BigDecimal.ZERO;
for (int k = 0; k < n; k++) {
    BigDecimal a0 = new BigDecimal(16).pow(k);
    BigDecimal a1 = new BigDecimal(4).divide(new BigDecimal(8*k+1), 20, RoundingMode.HALF_UP);
    BigDecimal a2 = new BigDecimal(2).divide(new BigDecimal(8*k+4), 20, RoundingMode.HALF_UP);
    BigDecimal a3 = new BigDecimal(1).divide(new BigDecimal(8*k+5), 20, RoundingMode.HALF_UP);
    BigDecimal a4 = new BigDecimal(1).divide(new BigDecimal(8*k+6), 20, RoundingMode.HALF_UP);
    BigDecimal a5 = a1.subtract(a2).subtract(a3).subtract(a4);
    BigDecimal a6 = BigDecimal.ONE.divide(a0, 20, RoundingMode.HALF_UP);
    pi.add(a5.multiply(a6));
    System.out.println(pi);
}