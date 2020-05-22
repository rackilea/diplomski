Pattern p = Pattern.compile("example\\((\\d+)\\)");
Matcher m = p.matcher(text);
if (m.find()) {
  int i = Integer.valueOf(m.group(1));
  ...
}