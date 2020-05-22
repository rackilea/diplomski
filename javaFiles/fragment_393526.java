import java.io.IOException;
import java.util.List; 
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*; 
import com.habelitz.jsobjectizer.unmarshaller.antlrbridge.generated.*; 
public class Main {
    public static void main(String... args) throws NoSuchFieldException, IllegalAccessException, IOException, RecognitionException {
        JavaLexer lexer = new JavaLexer(new ANTLRFileStream(args[1], "UTF-8"));
        JavaParser parser = new JavaParser(new CommonTokenStream(lexer));
        CommonTree tree = (CommonTree)(parser.javaSource().getTree());
        int type = ((Integer)(JavaParser.class.getDeclaredField(args[0]).get(null))).intValue();
        System.out.println(count(tree, type));
    }
    private static int count(CommonTree tree, int type) {
        int count = 0;
        List children = tree.getChildren();
        if (children != null) {
            for (Object child : children) {
                count += count((CommonTree)(child), type);
            }
        }
        return ((tree.getType() != type) ? count : count + 1);
    }
}