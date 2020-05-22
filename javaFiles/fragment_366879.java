double r = 5.1234;
System.out.println(r); // r is 5.1234

int decimalPlaces = 2;
BigDecimal bd = new BigDecimal(r);

// setScale is immutable
bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
r = bd.doubleValue();

System.out.println(r); // r is 5.12