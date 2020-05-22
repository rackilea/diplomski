private void writeTextWithSymbol (String text) throws IOException {
    StringBuilder nonSymbolBuffer = new StringBuilder();
    for (char character : text.toCharArray()) {
        if (isCharacterEncodeable(character)) {
            nonSymbolBuffer.append(character);
        } else {
            //handle writing line with symbols...
        }
    }
    if (nonSymbolBuffer.length() > 0) {
        content.showText(nonSymbolBuffer.toString());
    }
}

private boolean isCharacterEncodeable (char character) throws IOException {
    try {
        currentFont.encode(Character.toString(character));
        return true;
    } catch (IllegalArgumentException iae) {
        LOGGER.trace("Character cannot be encoded", iae);
        return false;
    }
}