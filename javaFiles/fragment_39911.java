Double d = 0.0;
Integer i = 0;
System.out.println(d + " equals " + i + " is " + (d.equals(i)));

BigDecimal bd2 = new BigDecimal("0.00");
BigDecimal bd3 = new BigDecimal("0.000");

System.out.println(bd2 + " equals " + d + " is " + (bd2.equals(d)));
System.out.println(bd2 + " equals " + bd2 + " is " + (bd2.equals(bd2)));
System.out.println(bd2 + " equals " + bd3 + " is " + (bd2.equals(bd3)));