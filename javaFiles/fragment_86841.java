import org.antlr.runtime.*;

public class Main {
    public static void main(String[] args) {
        AntlrFormulaLexer lexer = new AntlrFormulaLexer(new ANTLRStringStream("(~ab)"));
        AntlrFormulaParser p = new AntlrFormulaParser(new CommonTokenStream(lexer));

        try {
            p.program();
            if ( p.failed() || p.getNumberOfSyntaxErrors() != 0) {
                System.out.println("failed");
            }
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}