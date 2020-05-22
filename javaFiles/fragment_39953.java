public int convert(char letter) {
    if (letter < 'a' || letter > 'z') {
        throw new IllegalArgumentException("Only lower-case ASCII letters are valid");
    }
    return letter - 'a';
}