String a = "9.8.0.0.10";
String b = "10.0.0.0.11";
String convertRegexp = "(^[0-9]{1,2}\\.[0-9]+)\\..*";        

double aAsDouble = Double.parseDouble(a.replaceAll(convertRegexp, "$1"));
double bAsDouble = Double.parseDouble(b.replaceAll(convertRegexp, "$1"));

if(aAsDouble > bAsDouble)