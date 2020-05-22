private BigInteger factorial(BigInteger input) {
    BigInteger output = input;
    for (BigInteger i = input.subtract(BigInteger.ONE); i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
        output = output.multiply(i);
    }
    return output;
}