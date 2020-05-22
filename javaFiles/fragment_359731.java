public class Main {

    public static void main(String[] args) throws Exception {

        String input = "@Annotation(\"class\")\n" +
                "class Mu {\n" +
                "\n" +
                "    @Annotation(\"field\")\n" +
                "    int x;\n" +
                "    \n" +
                "    @Annotation(\"method\")\n" +
                "    void withAnnotation(){}\n" +
                "    \n" +
                "    void withoutAnnotation(){}\n" +
                "}";

        JavaLexer lexer = new JavaLexer(new ANTLRInputStream(input));
        JavaParser parser = new JavaParser(new CommonTokenStream(lexer));

        //   classBodyDeclaration
        //       :   ...
        //       |   modifier* memberDeclaration
        //       ;
        //
        //   memberDeclaration
        //       :   methodDeclaration
        //       |   ...
        //       ;
        //
        //   methodDeclaration
        //       :   (type|'void') Identifier formalParameters ...
        //       ;
        //
        //   modifier
        //       :   classOrInterfaceModifier
        //       |   ...
        //       ;
        //
        //   classOrInterfaceModifier
        //       :   annotation
        //       |   ...
        //       ;
        ParseTreeWalker.DEFAULT.walk(new JavaBaseListener(){
            @Override
            public void enterClassBodyDeclaration(@NotNull JavaParser.ClassBodyDeclarationContext ctx) {

                if (!(ctx.memberDeclaration() != null && ctx.memberDeclaration().methodDeclaration() != null)) {
                    // No method declaration.
                    return;
                }

                String methodName = ctx.memberDeclaration().methodDeclaration().Identifier().getText();

                for (JavaParser.ModifierContext mctx : ctx.modifier()) {
                    if (mctx.classOrInterfaceModifier() != null && mctx.classOrInterfaceModifier().annotation() != null) {
                        System.out.println(methodName + " -> " + mctx.classOrInterfaceModifier().annotation().getText());
                    }
                }
            }
        }, parser.compilationUnit());
    }
}