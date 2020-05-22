@Override 
public void enterSemicolon(JavaParser.SemicolonContext ctx) {
    TerminalNode semi = ctx.semicolon(); // adjust as needed for your impl.
    Token tok = semi.getSymbol();
    int idx = tok.getTokenIndex();

    while(tok.getType() != IntStream.EOF) {
        System.out.println(tok);
        tok = tokens.get(idx++);
    }
}