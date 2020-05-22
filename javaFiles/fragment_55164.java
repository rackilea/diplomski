//Just an example, apply your formula here
    BigDecimal big = BigDecimal.valueOf(6.00);
    big = big.sqrt(MathContext.DECIMAL128);

    if (big.compareTo(big.setScale(0, RoundingMode.DOWN)) == 0) {
        return big.longValue();
    } else {
        return -1;
    }