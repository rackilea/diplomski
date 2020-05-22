public static int parseColor(final String color) {
    final Matcher mx = Pattern.compile("^#([0-9a-z]{2})([0-9a-z]{2})([0-9a-z]{2})$", CASE_INSENSITIVE).matcher(color);
    if(!mx.find())
        throw new IllegalArgumentException("invalid color value");
    final int R = Integer.parseInt(mx.group(1), 16);
    final int G = Integer.parseInt(mx.group(2), 16);
    final int B = Integer.parseInt(mx.group(3), 16);
    return (R << 16) + (G << 8) + B;
}