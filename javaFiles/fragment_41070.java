private static final String msg = "Syntax error: '%s' is not a valid var (at %s:%s).";

@Override 
public void exitVariableExp(VariableExpContext ctx) { 
    String value = lookupVariable(ctx.getText());
    if (value == null || value.isEmpty()) {
        Token tok = ctx.VARIABLE_NAME.getSymbol();
        int line = tok.getLine();              // 1..n
        int col = tok.getCharPositionInLine(); // 0..n
        System.out.println(String.format(msg, tok.getText(), line, col));            
    }
}