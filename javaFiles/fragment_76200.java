String str = "asdf asdf asdf asdf";
Pattern p = Pattern.compile("SOME_REGEX_HERE");
Matcher m = p.matcher(str);
if (m.find()) {
  System.out.println(m.group(0));
}