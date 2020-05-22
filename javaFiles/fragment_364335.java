import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

public class Main {
    public static void main(String[] args) throws Exception {
        JavaLexer lexer = new JavaLexer(new ANTLRFileStream("Test.java"));
        JavaParser parser = new JavaParser(new CommonTokenStream(lexer));
        CommonTree tree = (CommonTree)parser.javaSource().getTree();
        DOTTreeGenerator gen = new DOTTreeGenerator();
        StringTemplate st = gen.toDOT(tree);
        System.out.println(st);
    }
}