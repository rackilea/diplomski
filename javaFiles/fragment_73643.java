import org.antlr.runtime.*;

public class Main {
  public static void main(String[] args) throws Exception {
    ANTLRStringStream in = new ANTLRStringStream(args[0]);
    PropLogicLexer lexer = new PropLogicLexer(in);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    PropLogicParser parser = new PropLogicParser(tokens);
    parser.prog();
  }
}