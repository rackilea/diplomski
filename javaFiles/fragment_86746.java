package i;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

public class TestiGrammar {
  public static void main(String[] args) throws Exception {
    InputStream resource = TestiGrammar.class.getResourceAsStream("itest.txt");

    CharStream input = new ANTLRInputStream(resource);

    resource.close();

    iLexer lexer = new iLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    iParser parser = new iParser(tokens);
    parser.selects();
  }
}