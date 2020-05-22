public static void main(String[] args) {
    BigDecimal d1 = new BigDecimal("0.979");
    BigDecimal d2 = new BigDecimal("3");
    BigDecimal d3 = new BigDecimal("21");
    BigDecimal d4 = d1.multiply(d2.divide(d3, MathContext.DECIMAL128));
    System.out.println("d4 " + d4);
}