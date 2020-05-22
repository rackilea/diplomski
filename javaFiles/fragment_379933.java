public String unescape(String s) {
    StringBuilder result = new StringBuilder();
    for (char c : s.toCharArray()) {
        result.append(toLiteral(c));
    }
    return result.toString();
}

private String toLiteral(char c) {
    switch (c) {
    case '\n':
        return "\\n";
    case '\t':
        return "\\t";
    case '\r':
        return "\\r";
    case '\f':
        return "\\f";
    case '\b':
        return "\\b";
    case '\'':
        return "\\\'";
    case '\"':
        return "\\\"";
    case '\\':
        return "\\\\";
    default:
        return c;
    }
}