import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Test {
    public static void main(String[] args) throws Exception {
        String query = "query(std::map .find(x) == y): bla";
        ANTLRInputStream input = new ANTLRInputStream(query);
        PQLCLexer lexer = new PQLCLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PQLCParser parser = new PQLCParser(tokens);
        ParseTree tree = parser.query(); // begin parsing at query rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    }
}