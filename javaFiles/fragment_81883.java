System.out.println(new BigDecimal("123.4",
                   new MathContext(4,RoundingMode.HALF_UP)));
System.out.println(new BigDecimal("123.4",
                   new MathContext(2,RoundingMode.HALF_UP)));
System.out.println(new BigDecimal("123.4",
                   new MathContext(2,RoundingMode.CEILING)));
System.out.println(new BigDecimal("123.4",
                   new MathContext(1,RoundingMode.CEILING)));