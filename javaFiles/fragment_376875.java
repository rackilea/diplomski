private String justify(String s) {
    if (width == -1)
    return s;
    StringBuilder sb = new StringBuilder();
    boolean pad = f.contains(Flags.LEFT_JUSTIFY);
    int sp = width - s.length();
    if (!pad)
    for (int i = 0; i < sp; i++) sb.append(' ');
    sb.append(s);
    if (pad)
    for (int i = 0; i < sp; i++) sb.append(' ');
    return sb.toString();
}