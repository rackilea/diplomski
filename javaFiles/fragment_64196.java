private static final Pattern p = Pattern
        .compile( "(?<!\\d[^a-z\\d]{0,10000})"
                + "\\d([^a-z\\d]*\\d){3}([^a-z\\d]*\\d)?"
                + "(?![^a-z\\d]*\\d)", Pattern.CASE_INSENSITIVE);

public static String replaceSpecial(String text) {
    StringBuffer sb = new StringBuffer();
    Matcher m = p.matcher(text);
    while (m.find()) {
        m.appendReplacement(sb, m.group(2) == null ? "****" : "*****");
    }
    m.appendTail(sb);
    return sb.toString();
}