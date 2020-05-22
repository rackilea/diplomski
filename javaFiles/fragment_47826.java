Locale currentLocale = Locale.getDefault();
String formatString = "#,###,###,###.##";
DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
otherSymbols.setDecimalSeparator(',');
otherSymbols.setGroupingSeparator('.');
DecimalFormat df = new DecimalFormat(formatString, otherSymbols);

double price = 200.12357123;

Log.i("TAG", "" + "$ " + df.format(price));