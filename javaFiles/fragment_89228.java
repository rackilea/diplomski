NumberFormat formatter = NumberFormat.getNumberInstance(Locale.ENGLISH);
// NumberConverter turns input string into Number
Number number = formatter.parse("10,10");
// Expression language coerces the Number to BigDecimal
BigDecimal decimal = BigDecimal.valueOf(number.doubleValue());
// On output back to browser:
String output = formatter.format(decimal);
System.out.println(output);