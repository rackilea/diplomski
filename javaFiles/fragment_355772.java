String value1 = "Bar Foo Bar: Foo8:16 Foo Bar Bar foo barz";
String pattern1 = "\\d+:(\\d+)"; // <= The first group is the \d+ in round brackets
Pattern ptrn = Pattern.compile(pattern1);
Matcher matcher = ptrn.matcher(value1);
if (matcher.find())
    System.out.println(matcher.group(1)); // <= Print the value captured by the first group
else
    System.out.println("false");