static String uescape(String s) {
    StringBuilder sb = new StringBuilder(s.length() * 6);
    for (int i = 0; i < chars.length; ++i) {
        char ch = s.charAt(i);
        if (ch < 128) {
            sb.append(ch);
        } else {
            sb.append(String.format("\\u%04X", (int) ch));
        }
    }
    return sb.toString();
}

errors.add(uescape(str));