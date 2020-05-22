final String searchString = "12345.html";
final String txt =
"<a href=\"12345.html\"><a href=\"12345.html\"><a href=\"12345.html\"><a href=\"12345.html\">\n"
+ "<a href=\"12345.html\"><a href=\"12345.html\"><a href=\"12345.html\"><a href=\"12345.html\">";
final Matcher matcher = Pattern.compile(searchString, Pattern.LITERAL).matcher(txt);
final StringBuilder sb = new StringBuilder();
while(matcher.find()){
    if(sb.length() > 0) sb.append(',');
    sb.append(matcher.group());
}
System.out.println(sb.toString());