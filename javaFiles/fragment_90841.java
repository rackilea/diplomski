String regex = "\"([^\"\\\\]*(?:\\\\.[^\"\\\\]*)*)\"";
String bookText = "\"What's the matter?\" inquired Captain MacWhirr. \"Seems all right to me.\"";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(bookText);

while (m.find()) {
    System.out.println(m.group(1));
}