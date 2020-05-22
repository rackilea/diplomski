public static void main(String[] args) {
  double x = 2.3333333333312398;
  BigDecimal big = BigDecimal.valueOf(2.3333333333312398);
  BigDecimal big2 = new BigDecimal("2.3333333333312398");

  System.out.println(x);
  System.out.println(big);

  System.out.println(big2);
}