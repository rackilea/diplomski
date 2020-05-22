Pattern p = Pattern.compile("[^/]+\\.jpg");
Matcher m = p.matcher(str);
if (m.find()) {
  String match = m.group();
  System.out.println(match);
}