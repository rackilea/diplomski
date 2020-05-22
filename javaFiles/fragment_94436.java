public String baseConvert(final BigInteger number, final String charset) {
    BigInteger quotient;
    BigInteger remainder;
    final StringBuilder result = new StringBuilder();
    final BigInteger base = BigInteger.valueOf(charset.length());
    do {
        remainder = number.remainder(base);
        quotient = number.divide(base);
        result.append(charset.charAt(remainder.intValue()));
        number = number.divide(base);
    } while (!BigInteger.ZERO.equals(quotient));
    return result.reverse().toString();
}