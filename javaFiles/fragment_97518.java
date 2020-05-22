String text = "{<<\"user_1\">>, [<<\"user_2\">>,<<\"user_3\">>,<<\"user_04\">>]}";
String regex = "<<\"(\\w+)\">>";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(text);
while (m.find()) {
  System.out.format("found: %s\n", m.group(1));
}