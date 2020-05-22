String s = "10 50 u E2U+pstn:tel \"!^(.*)$!tel:\\\\1;spn=42180;mcc=234;mnc=33!\"";
Pattern p = Pattern.compile("^.*spn=([0-9]+);mcc=([0-9]*);mnc=([0-9]*)!.*$");
Matcher matcher = p.matcher(s);
matcher.matches(); // true
String spn = matcher.group(1); // 42180
String mcc = matcher.group(2); // 234
String mnc = matcher.group(3); // 33