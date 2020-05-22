public static int parseHex(final String color) {
    final Matcher mx = Pattern.compile("^#([0-9a-z]{6})$", CASE_INSENSITIVE).matcher(color);
    if(!mx.find())
        throw new IllegalArgumentException("invalid color value");
    return Integer.parseInt(mx.group(1), 16);
}