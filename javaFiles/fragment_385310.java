DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
unusualSymbols.setDecimalSeparator(',');
unusualSymbols.setGroupingSeparator('.');
String pattern = "#,###,###";
int value = 1000000;
DecimalFormat myFormatter = new DecimalFormat(pattern, unusualSymbols);
String output = myFormatter.format(value);
System.out.println(value + " " + pattern + " " + output);