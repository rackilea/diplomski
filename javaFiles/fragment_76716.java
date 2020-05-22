public static BigDecimal parse(final String amount, final Locale locale) throws ParseException {
    final NumberFormat format = NumberFormat.getNumberInstance(locale);
    if (format instanceof DecimalFormat) {
        ((DecimalFormat) format).setParseBigDecimal(true);
    }
    return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]",""));
}