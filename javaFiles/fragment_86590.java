BigDecimal x= BigDecimal.valueOf(0.0004);
BigDecimal y = x.multiply(new BigDecimal("100"));
int z = y.intValue();
System.out.printf("y is %s\tz is %d%n", y, z);
// edit to truncate fractional digits
NumberFormat nf = NumberFormat.getInstance();
nf.setMaximumFractionDigits(2);
System.out.printf("y (2 fraction digits) is %s", nf.format(y));