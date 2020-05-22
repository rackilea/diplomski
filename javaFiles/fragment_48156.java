String maskChar = "*";

//number of characters to be masked
String maskString = StringUtils.repeat( maskChar, 4);

//string to be masked
String str = "FirstName";

//this will mask first 4 characters of the string
System.out.println( StringUtils.overlay(str, maskString, 0, 4) );