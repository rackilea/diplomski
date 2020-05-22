String input = "\\n hello \\t world \\r";

String from = "ntrf";
String to   = "\n\t\r\f";
Matcher m = Pattern.compile("\\\\(["+from+"])").matcher(input);
StringBuffer sb = new StringBuffer();
while (m.find())
    m.appendReplacement(sb, "" + to.charAt(from.indexOf(m.group(1))));
m.appendTail(sb);

System.out.println(sb.toString());