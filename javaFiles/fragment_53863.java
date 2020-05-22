public static String formatValueString(String currencyISO, double value) {
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
    numberFormat.setCurrency(java.util.Currency.getInstance(currencyISO));
    numberFormat.setMinimumFractionDigits(0);
    numberFormat.setMaximumFractionDigits(0);
    String result = numberFormat.format(value);
    return result;
}