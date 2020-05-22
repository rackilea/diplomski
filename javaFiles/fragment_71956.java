private static int getLetterWeight(char ch) {
    if (!Character.isLetter(ch)) {
        return 0;
    }
    return (Character.isUpperCase(ch)) ? 1 + (ch - 'A') : -1 - (ch - 'a');
}