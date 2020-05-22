String org = "$16500.00";
String numbersOnly = org.substring(1);   // "16500.00"
int yourInteger = (int)(Float.parseFloat(numbersOnly));

// if you need String, convert it to String again
String integerString = Integer.toString(yourInteger);