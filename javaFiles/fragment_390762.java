public class CMyListener extends CBaseListener {
    CParser parser;
    public CMyListener(CParser parser) { this.parser = parser; }

    public void exitCompilationUnit(CParser.CompilationUnitContext ctx) {
        System.out.println(parser.getTokenStream().getText(ctx));
    }
}