String s = "//name:value /name:value // name:value";
Pattern p = Pattern.compile("//?\\s*(\\w+):(\\w+)\\s*");
Matcher m = p.matcher(s);
while (m.find()) {
  System.out.printf("%s = '%s'%n", m.group(1), m.group(2));
}