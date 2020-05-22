public static List<String> parse(String text) {
    List<String> tokens = new ArrayList<>();
    boolean escaped = false;
    StringBuilder sb = new StringBuilder();

    for (char ch : text.toCharArray()) {
        if (ch == ',' && !escaped) {
            tokens.add(sb.toString());
            sb.delete(0, sb.length());
        } else {
            if (ch == '\\')
                escaped = !escaped;
            else
                escaped = false;
            sb.append(ch);
        }
    }

    if (sb.length() > 0) {
        tokens.add(sb.toString());
        sb.delete(0, sb.length());
    }

    return tokens;
}