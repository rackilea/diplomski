public static void assertSafeInt(String val) {
    try {
        Integer.parseInt(val);
    } catch (NumberFormatException e) {
        throw new AssertionError(val + " is not an int");
    }
}