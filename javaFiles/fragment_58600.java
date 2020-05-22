private void adjustFormatSymbols(Locale locale, DecimalFormat df) {
        if ("ar".equals(locale.getLanguage())) {
            DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
            // set the beginning of the range to Arabic digits
            dfs.setZeroDigit('\u0660');
            df.setDecimalFormatSymbols(dfs);
        }
    }