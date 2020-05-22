String s = "Your_string-123.";
Pattern p = Pattern.compile("([a-zA-Z]|[0-9]|\\.|\\-|_)+");
Matcher m = p.matcher(s);
if (m.matches()) {
  System.out.println(true);
}