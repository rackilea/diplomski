String pattern = "(?i)\\bLLC\\b";
String replacement = "LLC";
String unformatted = "Midwest Horticultural Llc";

String formatted = unformatted.replaceAll(pattern, replacement);
System.out.println(formatted);