// lets say you have two Strings, one with a simple int number and one floating point number
String anIntegerString = "1234";
String aDoubleString = "1234.123";

// you can parse the String with the integer value as  double 
double integerStringAsDoubleValue = Double.parseDouble(anIntegerString);
System.out.println("integer String as double value = " + integerStringAsDoubleValue);

// or you can parse the integer String as an int (of course)
int integerStringAsIntValue = Integer.parseInt(anIntegerString);
System.out.println("integer String as int value = " + integerStringAsIntValue);

 // if you have a String with some sort of floating point number, you can parse it as double
double doubleStringAsDoubleValue = Double.parseDouble(aDoubleString);
System.out.println("double String as double value = " + doubleStringAsDoubleValue);

// but you will not be able to parse an int as double
int doubleStringAsIntegerValue = Integer.parseInt(aDoubleString); // this throws a NumberFormatException because you are trying to force a double into an int - and java won't assume how to handle the digits after the . 
System.out.println("double String as int value = " + doubleStringAsIntegerValue);