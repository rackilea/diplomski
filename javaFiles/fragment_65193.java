import org.antlr.runtime.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String source = "call ABC call /* DEF */ ABC";
    ExampleLexer lexer = new ExampleLexer(new ANTLRStringStream(source));
    ExampleParser parser = new ExampleParser(new CommonTokenStream(lexer));
    parser.parse();
  }
}