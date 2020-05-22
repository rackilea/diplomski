DecimalFormat currencyFormatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());

currencyFormatter.setMaximumFractionDigits(2); // << This should
currencyFormatter.setMinimumFractionDigits(2); // << do the trick

System.out.println(currencyFormatter.format(-123456.7812));