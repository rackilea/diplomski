String foo = "25/09/2013,14:24:30 2412 914.0";
String delims = "[, ]+";
String[] tokens = foo.split(delims);

String d = tokens[0]; // d would contain the string '25/09/2013'
String t = tokens[1]; // t would contain the string '14:24:30'
int n1 = Integer.parseInt(tokens[2]); // n1 would contain the integer 2412
double n2 = Double.parseDouble(tokens[3]); // n2 would contain the double 914.0