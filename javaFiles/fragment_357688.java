import org.eclipse.jdt.core.dom.ASTParser;

String javaSource = "some java source"'

    // see org.eclipse.jdt.core.dom.AST for a complete
    // list of supported levels.
ASTParser parser = ASTParser.newParser(AST.JLS2);
parser.setSource(javaSource.toCharArray());
CompilationUnit unit = (CompilationUnit) parser.createAST(null);