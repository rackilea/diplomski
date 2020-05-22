if (Character.isDigit(c)) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < Character.digit(c, 10); i++) {
        sb.append(compressedText.charAt(1));
    }

    return sb.toString() + decompress(compressedText.substring(2));
}