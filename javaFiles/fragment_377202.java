public static String getIdentifier(String str) {
    try {
        return Arrays.toString(str.getBytes("UTF-8")).replaceAll("\\D+", "_");
    } catch (UnsupportedEncodingException e) {
        // UTF-8 is always supported, but this catch is required by compiler
        return null;
    }
}