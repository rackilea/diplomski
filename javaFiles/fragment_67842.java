int exponent = getExponentForNumber(25.003);
int basis = Integer.valueOf(String.valueOf(25.003).replace(".", ""));
String expression = "25.003 equals " + basis + "*10^" + exponent;
System.out.println(expression);

25.003 equals 25003*10^-3