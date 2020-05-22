String term = "32x^33";
String[] tokens = term.split("\\^");
String coeff = tokens[0].substring(0, tokens[0].length()-1);
String var = tokens[0].substring(tokens[0].length()-1, tokens[0].length());
String exp = tokens[1];
System.out.println("coeff = "+coeff+", var = "+var+", exp = "+exp);