Pattern p = Pattern.compile("(.+) (\\d+/\\d+/\\d+) (.+)");
Matcher m = p.matcher(record);
if (!m.matches()) 
  throw new IllegalArgumentException("Invalid record format.");
String venue = m.group(1);
String date = m.group(2);
String result = m.group(3);
...