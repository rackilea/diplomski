import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

class FooTest {
  public static void main(String[] args) throws Exception {    
    String text = "aaa | bbb | ccc";        
    System.out.println("parsing: "+text);        
    ANTLRStringStream in = new ANTLRStringStream(text);
    test01Lexer lexer = new test01Lexer(in);
    CommonTokenStream tokens = new TokenRewriteStream(lexer);
    test01Parser parser = new test01Parser(tokens);
    CommonTree root = (CommonTree)parser.test().getTree();
    for(int i = 0; i < root.getChildCount(); i++) {
      CommonTree child = (CommonTree)root.getChild(i);
      System.out.println("root.children[" + i + "] = " + child);
    }
  }
}