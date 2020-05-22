public static String scrub(String input) {

    // remove all non-alphanumeric characters
    String sanitized = alphanumericOnly(input);

    // trick Fortify by storing chars
    // as codepoints in an int array
    int[] codepoints = new int[sanitized.length()];

    for(int i = 0; i < sanitized.length(); ++i) {
        codepoints[i] = sanitized.codePointAt(i);
    }

    return new String(codepoints, 0, codepoints.length);
}