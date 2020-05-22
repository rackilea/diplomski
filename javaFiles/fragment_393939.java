// we must use Locale.US, because we want to make sure that the DataFormatter will
// always product "." as decimal-separator and "," as thousands-separator.
this.formatter = new DataFormatter(Locale.US);

// format the floating-point value
String xlsxValue = formatter.formatRawCellContents(
        Double.parseDouble(value),
        formatIndex,
        formatString);

// xlsxValue may contain format-symbols, which we need to remove...
xlsxValue = xlsxValue.replaceAll("[^\\d.]", "");