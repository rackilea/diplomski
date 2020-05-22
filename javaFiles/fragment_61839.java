String regExpression = "^(.*?)\\}";
Pattern one = Pattern.compile(regExpression);
Matcher matcherone = one.matcher("[{test},{test2}]");
String Text = "";
if (matcherone.find()) {
  Text = matcherone.group();
}
System.out.println(Text);