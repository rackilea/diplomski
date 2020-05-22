Pattern p = Pattern.compile("([A-Z]|_)+"); 
String s = "test=\"UPPERCASE\" other=\"lowercase\" map=\"UPPER\"";
Matcher m = p.matcher(s);
while (m.find()) {
  String group = m.group(0);
  System.out.println(group.toLowerCase());  // will print "uppercase" and "upper"
}