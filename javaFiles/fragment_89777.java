public static NumberFormat localStyleForeignFormat(Locale locale) {
    NumberFormat format = NumberFormat.getCurrencyInstance(locale);
    if (format instanceof DecimalFormat) {
        DecimalFormat df = (DecimalFormat) format;
        // use local/default decimal symbols with original currency symbol
        DecimalFormatSymbols dfs = new DecimalFormat().getDecimalFormatSymbols();
        dfs.setCurrency(df.getCurrency());
        df.setDecimalFormatSymbols(dfs);
    }
    return format;
}