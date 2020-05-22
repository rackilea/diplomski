static String unvowel(String s) {
    Matcher m = Pattern.compile("(?i)[aeiou]").matcher(s);
    StringBuffer sb = new StringBuffer();
    while (m.find()) {
        m.appendReplacement(sb, String.valueOf(m.start()));
    }
    m.appendTail(sb);
    return sb.toString();
}