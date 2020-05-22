String text = "AAA-BBB-CCC-{AAA-BBB-AAA-BBB}-CCC-BBB-AAA";
Pattern r = Pattern.compile("\\{[^{}]*}|(A)");
Matcher m = r.matcher(text);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    if (m.group(1) == null) {
        m.appendReplacement(sb,  m.group(0));
    } else {
        m.appendReplacement(sb,  "I");
    }
}
m.appendTail(sb);
System.out.println(sb);