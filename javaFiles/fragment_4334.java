String dump(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ) {
        int cp = s.codePointAt(i);
        if (32 < cp && cp < 128) {
            sb.append((char) cp);
        } else {
            sb.append("U+").append(Integer.toHexString(cp));
        }
        sb.append(' ');
        i += Character.charCount(cp);
    }
    return sb.toString();
}