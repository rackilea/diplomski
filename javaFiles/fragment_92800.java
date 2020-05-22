public static void main(String[] args) {
    double p = 2233.64344206d;
    BigDecimal d = new BigDecimal(p);
    int n = 10;
    int integralDigits = d.toBigInteger().toString().length();
    d = d.setScale(n - integralDigits, RoundingMode.HALF_EVEN);
    System.out.println(d);
}