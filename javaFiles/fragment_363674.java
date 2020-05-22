BigDecimal num = new BigDecimal(1.00).setScale(2);
    BigDecimal divisor = new BigDecimal(3.00).setScale(2);

    BigDecimal result = num.divide(divisor, BigDecimal.ROUND_HALF_UP);

    System.out.print(result);