public static String formatDecimal(BigDecimal number, int maxChars) {
    String s;
    int precision = maxChars;
    do {
        s = number
                .round(new MathContext(precision, RoundingMode.HALF_EVEN))
                .stripTrailingZeros()
                .toString();
        --precision;
    } while (s.length() > maxChars && precision > 0);
    return s;
}