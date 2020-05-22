float a1 = 1.4f;
float b1 = 0.5f;
double c1 = 1.4;
double d1 = 0.5;

System.out.println(new BigDecimal(a1) + " - " + new BigDecimal(b1) + " is " +
        new BigDecimal(a1).subtract(new BigDecimal(b1)) + " or as a float is " + (a1 - b1));
System.out.println(new BigDecimal(c1) + " - " + new BigDecimal(d1) + " is " +
        new BigDecimal(c1).subtract(new BigDecimal(d1)) + " or as a double is " + (c1 - d1));