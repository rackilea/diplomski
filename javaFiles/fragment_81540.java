public final class Brace {
    private final char openBrace;
    private final char closeBrace;
    private final int row;
    private final int col;

    public Brace(char openBrace, int row, int col) {
        this.openBrace = openBrace;
        this.row = row;
        this.col = col;

        switch (openBrace) {
            case '(':
                closeBrace = ')';
                break;
            case '{':
                closeBrace = '}';
                break;
            case '[':
                closeBrace = ']';
                break;
            default:
                throw new IllegalArgumentException("Unsupported opening brace");
        }
    }

    public boolean isClosingBrace(char ch) {
        return closeBrace == ch;
    }
}