Pattern pattern = Pattern.compile("\\\\u([0-9A-Fa-f]{4,5})\\b");
StringBuffer sb = new StringBuffer();
Matcher m = pattern.matcher(s);
while (m.find()) {
    int cp = Integer.parseInt(m.group(1), 16);
    String added = cp < 0x10000
        ? String.valueOf((char) cp)
        : new String(new int[] { cp }, 0, 1);
    m.appendReplacement(sb, added);
}
m.appendTail(sb);
s = sb.toString();