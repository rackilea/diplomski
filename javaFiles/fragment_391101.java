public static String getFormatted(double value, int decimalCount) {
    StringBuilder numberPattern = new StringBuilder(
            (decimalCount <= 0) ? "" : ".");
    for (int i = 0; i < decimalCount; i++) {
        numberPattern.append('0');
    }
    return NumberFormat.getFormat(numberPattern.toString()).format(value);
}