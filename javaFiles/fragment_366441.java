MathContext mc = new MathContext(52, RoundingMode.HALF_EVEN);
BigDecimal bd = new BigDecimal(5);
bd = bigSqrt(bd);
bd = bd.add(BigDecimal.ONE);
bd = bd.pow(100, mc);
System.out.println(bd);