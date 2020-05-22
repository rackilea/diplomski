private static boolean isChanged(String before, String after) {
    if (before == null) {
        return after == null;
    } else {
        return before.equals(after);
    }
}