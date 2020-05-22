public static String decompress(String compressedText) {
    if (compressedText.length() <= 1) {
        return compressedText;
    }

    char c = compressedText.charAt(0);

    if (Character.isDigit(c)) {
        return repeatCharacter(compressedText.charAt(1), Character.digit(c, 10)) + decompress(compressedText.substring(2));
    }

    return compressedText.charAt(0) + decompress(compressedText.substring(1));
}

public static String repeatCharacter(char character, int counter) {
    if (counter == 1) {
        return Character.toString(character);
    }

    return character + repeatCharacter(character, counter - 1);
}