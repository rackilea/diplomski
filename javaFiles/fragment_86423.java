StringBuilder out = new StringBuilder(str.length + 10);
for (String d : str.split("\\s+")) {
    int codePoints = d.codePointCount(0, d.length());
    if (codePoints >= 2) {
        int startChar = d.codePointAt(0);
        int endChar = d.codePointBefore(d.length());
        out.appendCodePoint(startChar).append("***").appendCodePoint(endChar).append(' ');
    } else if (codePoints == 1) {
        out.append(d).append("***").append(' ');
        // Or: out.append("* ");
    }
}
return out.toString().trim();