public static void main(String[] args) throws Exception{
  List<String> lines = new ArrayList<String>();

  Pattern p = Pattern.compile("\\{.*\\}");
  Matcher matcher = p.matcher(input);
  while (matcher.find()) {
    lines.add(matcher.group());
  }
}