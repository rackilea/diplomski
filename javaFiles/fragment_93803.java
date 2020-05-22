public static String decompress(String compressedText) {
    if (compressedText.length() <= 1) {
        return compressedText;
    }

    char c = compressedText.charAt(0);

    if (Character.isDigit(c)) {
        return String.join("", Collections.nCopies(Character.digit(c, 10), compressedText.substring(1, 2))) + decompress(compressedText.substring(2));
    }

    return compressedText.charAt(0) + decompress(compressedText.substring(1));
}