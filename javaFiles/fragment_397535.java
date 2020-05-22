public class Walker implements YourJavaListener {

    CommonTokenStream tokens;

    public Walker(JavaParser parser) {
        tokens = (CommonTokenStream) parser.getTokenStream()
    }