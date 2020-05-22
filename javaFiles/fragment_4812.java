String addstr = "=1";
String str = "(a AND b) OR (c AND d) ";

StringBuffer sb = new StringBuffer();

Pattern pattern = Pattern.compile("[a-z]+");
Matcher m = pattern.matcher(str);
while (m.find()) {
    m.appendReplacement(sb, m.group() + addstr);
}
m.appendTail(sb);
System.out.println(sb);