public void myMethod(BigDecimal b) {
    BigDecimal zero = BigDecimal.ZERO;
    if (b.compareTo(zero) > 0)
        b = zero;
    // Do stuff with b here
}