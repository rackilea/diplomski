import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.*;

public class Main {

    private static void preOrder(CommonTree tree, int depth) {
        for(int i = 0; i < depth; i++) {
            System.out.print("- ");
        }
        System.out.println("> "+tree + " :: " + ExpParser.tokenNames[tree.getType()]);
        List children = tree.getChildren();
        if(children == null) return;
        for(Object o : children) {
            preOrder((CommonTree)o, depth+1);
        }
    }

    public static void main(String[] args) throws Exception {
        ANTLRStringStream in = new ANTLRStringStream("3 * (4 + 7 * 6) * (3 + 7 * (4 + 2))");
        ExpLexer lexer = new ExpLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokens);
        CommonTree tree = (CommonTree)parser.parse().getTree();
        preOrder(tree, 0);
    }
}