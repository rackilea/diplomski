String s = "111";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("(.)\\1+").matcher(s);
while (m.find()) {
    m.appendReplacement(result, m.group().length() + m.group(1));
}
m.appendTail(result);
System.out.println(result.toString()); // => 31