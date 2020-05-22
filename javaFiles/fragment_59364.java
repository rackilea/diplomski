public class Main {

    public static void main(String[] args) throws Exception {

        final String source = "class Item {}\n" +
                "class First {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = 3;\n" +
                "        int b;\n" +
                "        b = a + 1;\n" +
                "        Item i = new Item();\n" +
                "        i = new Item();\n" +
                "        System.out.println(b);\n" +
                "    }\n" +
                "}";

        final JavaLexer lexer = new JavaLexer(new ANTLRInputStream(source));
        final JavaParser parser = new JavaParser(new CommonTokenStream(lexer));
        final List<String> variables = new ArrayList<>();

        ParseTreeWalker.DEFAULT.walk(new JavaBaseListener() {
            // variableDeclarator
            //     :   variableDeclaratorId ('=' variableInitializer)?
            //     ;
            @Override
            public void enterVariableDeclarator(@NotNull JavaParser.VariableDeclaratorContext ctx) {
                variables.add(ctx.variableDeclaratorId().getText());
            }
        }, parser.compilationUnit());

        System.out.printf("variable=%s", variables);
    }
}