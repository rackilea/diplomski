double d = 1.0025443684293908E-20;
BigDecimal num = BigDecimal.valueOf(d);
BigDecimal result = BigDecimal.ONE.subtract(num);

System.out.println(result.toPlainString());
// 0.999999999999999999989974556315706092