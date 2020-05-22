int signOf2 = n2.signum();
    try {
        // Perform X^(A+B)=X^A*X^B (B = remainder)
        double dn1 = n1.doubleValue();
        // Compare the same row of digits according to context
        if (!CalculatorUtils.isEqual(n1, dn1))
            throw new Exception(); // Cannot convert n1 to double
        n2 = n2.multiply(new BigDecimal(signOf2)); // n2 is now positive
        BigDecimal remainderOf2 = n2.remainder(BigDecimal.ONE);
        BigDecimal n2IntPart = n2.subtract(remainderOf2);
        // Calculate big part of the power using context -
        // bigger range and performance but lower accuracy
        BigDecimal intPow = n1.pow(n2IntPart.intValueExact(),
                CalculatorConstants.DEFAULT_CONTEXT);
        BigDecimal doublePow =
            new BigDecimal(Math.pow(dn1, remainderOf2.doubleValue()));
        result = intPow.multiply(doublePow);
    } catch (Exception e) {
        if (e instanceof CalculatorException)
            throw (CalculatorException) e;
        throw new CalculatorException(
            CalculatorConstants.Errors.UNSUPPORTED_NUMBER_ +
                "power!");
    }
    // Fix negative power
    if (signOf2 == -1)
        result = BigDecimal.ONE.divide(result, CalculatorConstants.BIG_SCALE,
                RoundingMode.HALF_UP);