private static final Pattern bound = Pattern.compile("\\b(\\w)");

public static String titleize(final String input) {
    StringBuffer sb = new StringBuffer(input.length());
    Matcher mat = bound.matcher(input);
    while (mat.find()) {
        mat.appendReplacement(sb, mat.group().toUpperCase());
    }
    mat.appendTail(sb);
    return sb.toString();
}