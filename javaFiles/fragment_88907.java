String url = "http://www.example.com/index.do/blah/1_44/asdf/asdf/asdf";
Pattern p = Pattern.compile("_(\\d+)");
Matcher m = p.matcher(url);
if (m.find()) {
  int number = Integer.valueOf(m.group(1));
}