String str = "...";

Pattern p = Pattern.compile("(?m)^(?:.+(?:\\r?\\n|\\Z)){2,}");
Matcher m = p.matcher(str);
while (m.find()) {
  String match = m.group();
  System.out.println(match);
}