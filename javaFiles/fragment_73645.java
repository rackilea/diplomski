import org.antlr.runtime.*;

public class Main {
  public static void main(String[] args) throws Exception {
    ANTLRStringStream in = new ANTLRStringStream("a b c");
    PropLogicLexer lexer = new PropLogicLexer(in);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    PropLogicParser parser = new PropLogicParser(tokens);
    parser.prog();
  }
}