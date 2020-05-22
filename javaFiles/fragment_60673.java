Pattern p = Pattern.compile("#([0-9A-Fa-f]{4})");
Matcher m = p.matcher(s);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    int c = Integer.parseInt(m.group(1), 16);
    m.appendReplacement(sb, String.valueOf((char) c));
}
m.appendTail(sb);
return sb.toString();