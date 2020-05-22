String str = "Jos\\u00e9_A\\u002e_Santos";
Matcher matcher = Pattern.compile("\\\\u([^_]+)").matcher(str);
StringBuffer sb = new StringBuffer();
while (matcher.find()) {
  matcher.appendReplacement(sb, "\\\\\\$" + matcher.group(1).toUpperCase());
}
matcher.appendTail(sb);
System.out.println("The original string "+ str+ "\n has been converted "+ sb.toString());