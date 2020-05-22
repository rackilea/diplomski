public static class Tools {

    // CharSequence covers both String and StringBuilder.
    public static int parseInt(CharSequence s) {
        return 4;
    }

    // Use Iterable instead of Vector (Vector implements List).
    public static int parseInt(Iterable<Character> v) {
        return 6;
    }

}