public static void main(String[] args) {
    Set<Character> arabicChars = findCharactersInUnicodeBlock(Character.UnicodeBlock.ARABIC);
    Set<Character> bengaliChars = findCharactersInUnicodeBlock(Character.UnicodeBlock.BENGALI);
}

private static Set<Character> findCharactersInUnicodeBlock(final Character.UnicodeBlock block) {
    final Set<Character> chars = new HashSet<Character>();
    for (int codePoint = Character.MIN_CODE_POINT; codePoint <= Character.MAX_CODE_POINT; codePoint++) {
        if (block == Character.UnicodeBlock.of(codePoint)) {
            chars.add((char) codePoint);
        }
    }
    return chars;
}