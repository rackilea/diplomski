String str = "1.2846202978398e+19";
BigDecimal d = new BigDecimal(str).multiply(BigDecimal.TEN);
//                                 ^^^^^^^^------example of arithmetic operations


System.out.println(String.format("%.0f", d));
System.out.println(String.format("%.0f", Double.parseDouble(str)));