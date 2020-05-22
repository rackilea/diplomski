Pattern p = Pattern.compile("([a-zA-Z]{2})-(\d+)");
Matcher m = p.matcher("DE-123");
if (m.matches()) {
  String letters = m.group(1);
  String numbers = m.group(2);
}