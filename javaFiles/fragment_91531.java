public static LocalDate getLocalDateFromString(String dateString) {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
    // Take a digit from dateString to determine which digits are used
    char sampleDigit = dateString.charAt(0);
    if (Character.isDigit(sampleDigit)) {
        // Subtract the numeric value of the digit to find the zero digit in the same digit block
        char zeroDigit = (char) (sampleDigit - Character.getNumericValue(sampleDigit));
        assert Character.isDigit(zeroDigit) : zeroDigit;
        assert Character.getNumericValue(zeroDigit) == 0 : zeroDigit;
        DecimalStyle defaultDecimalStyle = dateFormatter.getDecimalStyle();
        dateFormatter = dateFormatter
                .withDecimalStyle(defaultDecimalStyle.withZeroDigit(zeroDigit));
    }
    // If the examined char wasn’t a digit, the following parsing will fail;
    // but in that case the best we can give the caller is the exception from that failed parsing.
    LocalDate date = LocalDate.parse(dateString, dateFormatter);
    return date;
}