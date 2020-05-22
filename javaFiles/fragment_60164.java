Pattern p =
  Pattern.compile("^.*spn=(?<spn>[0-9]+);mcc=(?<mcc>[0-9]*);mnc=(?<mnc>[0-9]*)!.*$");
Matcher matcher = p.matcher(s);
matcher.matches(); // true
String spn = matcher.group("spn");
String mcc = matcher.group("mcc");
String mnc = matcher.group("mnc");