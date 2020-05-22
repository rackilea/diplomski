String input = getJSPString();

final Pattern p = Pattern.compile(
    "\".*?(?<!\\\\)\"|" +   // ignore string literals
    "(?s)<%--.*?--%>|" +    // ignore JSP comments
    "<!--(.*?)-->");        // capture HTML comments in group #1
Matcher m = p.matcher(input);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    if (m.group(1) != null) {
        m.appendReplacement(sb, "<%--$1--%>");
    }
}
m.appendTail(sb);
String output = sb.toString();