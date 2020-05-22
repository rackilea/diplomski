public List<String> getVariableNames(String source) {
  List<String> vs = new ArrayList<String>();
  Pattern p = Pattern.compile("\\$\\{(\\w+)\\}");
  Matcher m = p.matcher(source);
  while (m.find()) {
    vs.add(m.group(1));
  }
  return vs;
}