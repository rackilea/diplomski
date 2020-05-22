import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String src = 
        "for i 1 3          \n" + 
        "  print(i)         \n" + 
        "end                \n" + 
        "                   \n" + 
        "if fun(y, z) == 0  \n" + 
        "  print('foo')     \n" + 
        "end                \n";
    TLexer lexer = new TLexer(new ANTLRStringStream(src));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    CommonTree tree = (CommonTree)parser.parse().getTree();
    DOTTreeGenerator gen = new DOTTreeGenerator();
    StringTemplate st = gen.toDOT(tree);
    System.out.println(st);
  }
}