private void appendEvaluated(StringBuffer buffer, String s) {
    boolean escape = false;
    boolean dollar = false;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '\\' && !escape) {
            escape = true;
        } else if (c == '$' && !escape) {
            dollar = true;
        } else if (c >= '0' && c <= '9' && dollar) {
            buffer.append(group(c - '0'));
            dollar = false;
        } else {
            buffer.append(c);
            dollar = false;
            escape = false;
        }
    }

    // This seemingly stupid piece of code reproduces a JDK bug.
    if (escape) {
        throw new ArrayIndexOutOfBoundsException(s.length());
    }
}