public static Map<String, String> parse(String s) {
  Map<String, String> map = new HashMap<String, String>();
  Pattern p = Pattern.compile("(\\w+)\\s*=\\s*\"(.*?)\"");
  Matcher m = p.matcher(s);
  while (m.find()) {
    map.put(m.group(1), m.group(2));
  }
  return map;
}