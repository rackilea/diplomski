String s = "{{{abc}}";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("(\\{\\{[^{}]*}})|[{}]").matcher(s);
while (m.find()) {
    if (m.group(1) != null) {
        m.appendReplacement(result, m.group(1));
    } else {
        m.appendReplacement(result, "\\\\" + m.group());
    }
}
m.appendTail(result);
System.out.println(result.toString()); // Demo output.