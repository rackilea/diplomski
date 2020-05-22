BigDecimal d = BigDecimal.valueOf(5.5);
int a = 1;
int b = 11;

BigDecimal da = new BigDecimal(String.format("%s%02d", d, a));
BigDecimal db = new BigDecimal(String.format("%s%02d", d, b));

System.out.println(da);
System.out.println(db);