public static float floatValueExact(BigDecimal decimal) {
    float result = decimal.floatValue();
    if (!Float.isInfinite(result)) {
        if (new BigDecimal(String.valueOf(result)).compareTo(decimal) == 0) {
            return result;
        }
    }
    throw new ArithmeticException(String.format("%s: Cannot be represented as float", decimal));
}