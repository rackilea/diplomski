public class LUjATest {

    private static void findFunctions(CommonTree tree) {
        if (tree == null) return;

        if(tree.getType() == Lua52Parser.ASSIGNMENT) {

            String name = tree.getChild(0).getChild(0).getText();
            CommonTree expressions = (CommonTree) tree.getChild(1);

            if(expressions.getChildCount() > 0 &&
                    expressions.getChild(0).getType() == Lua52Parser.FUNCTION) {

                System.out.println("walk the tree:\n  " + expressions.toStringTree() +
                        "\nto find all strings for event: '" + name + "'");
            }
        }
        else {
            for (int i = 0; i < tree.getChildCount(); i++) {
                findFunctions((CommonTree) tree.getChild(i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Lua52Lexer lexer = new Lua52Lexer(new ANTLRFileStream("src/lua/test.lua"));
        Lua52Parser parser = new Lua52Parser(new CommonTokenStream(lexer));
        CommonTree tree = (CommonTree) parser.parse().getTree();
        findFunctions(tree);
    }
}