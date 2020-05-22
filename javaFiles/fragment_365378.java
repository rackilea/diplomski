private String enterToken(String tokenSymbol, String inputString, int column) {
    int colWidth = inputString.length() / 7;
    int tokenPos = (column-1) * colWidth;
    String inputStart = inputString.substring(0, tokenPos);
    String inputEnd = inputString.substring(tokenPos+1);
    return inputStart + tokenSymbol+inputEnd;
}