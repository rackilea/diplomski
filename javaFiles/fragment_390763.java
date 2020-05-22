import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class test_c {
    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRFileStream(args[0]);
        CLexer lexer = new CLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CParser parser = new CParser(tokens);
        ParseTree tree = parser.compilationUnit();
        System.out.println("parsing ended");
        ParseTreeWalker walker = new ParseTreeWalker();
        CMyListener my_listener = new CMyListener(parser);
        System.out.println(">>>> about to walk");
        walker.walk(my_listener, tree);
    }
}