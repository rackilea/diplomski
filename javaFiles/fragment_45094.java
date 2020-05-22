private static boolean validateInput(String text) {
    if (text != null) {
        return text.matches(PATTERN_DOUBLE_QUOTED);
    }
    return false;
}