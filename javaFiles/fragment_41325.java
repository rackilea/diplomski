final BigDecimal n1 = new BigDecimal(request.getParameter("num1").toString().trim());
final BigDecimal n2 = new BigDecimal(request.getParameter("num2").toString().trim());

final BigDecimal res = n1.add(n2);
final BigDecimal remainder = n1.remainder(n2);

//if (res.stripTrailingZeros().scale() > 0) {
if (remainder.compareTo(BigDecimal.ZERO) != 0) {
    System.out.println("It's decimal");
    System.out.println(res);
} else {
    final DecimalFormat df = new DecimalFormat("#.0f");
    System.out.println(df.format(res));
}