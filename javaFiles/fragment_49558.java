String yourString = "Example [2] This is a sample text. This is a sample text. This is a sample text.";
Pattern p = Pattern.compile("sample", Pattern.LITERAL);
Matcher m = p.matcher(yourString);
StringBuffer sb = new StringBuffer();
boolean firstWordAlreadyFound = false;
while (m.find()) {
    if (firstWordAlreadyFound) {
        m.appendReplacement(sb, "sImple");
    } else {
        m.appendReplacement(sb, m.group());
        firstWordAlreadyFound = true;
    }
}
m.appendTail(sb);
String result = sb.toString();
System.out.println(result);