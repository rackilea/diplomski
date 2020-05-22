import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Main {
  public static void main(String args[]) throws Exception {
    INTcLexer lex = new INTcLexer(new ANTLRStringStream("true and false\n"));
    CommonTokenStream tokens = new CommonTokenStream(lex);
    INTcParser parser = new INTcParser(tokens);

    CommonTree t  = (CommonTree)parser.prog().getTree();
    CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
    INTcWalker evaluator = new INTcWalker(nodes);

    System.out.println(t.toStringTree());

    CommonTree tr;
    while(true) {
      Token token = ((CommonTree)nodes.nextElement()).getToken();
      if(token.getType() == INTcParser.EOF) break;
      System.out.printf("%-10s '%s'\n", INTcParser.tokenNames[token.getType()], token.getText());
    }

    System.out.println("\nresult=" + evaluator.getResult());
  }
}