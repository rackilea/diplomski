private static long extractLong(Number value) {
    double v = value.doubleValue();
    if (v < Long.MIN_VALUE || v > Long.MAX_VALUE) {
        throw new NumberFormatException(...);
    }
    return value.longValue();
}