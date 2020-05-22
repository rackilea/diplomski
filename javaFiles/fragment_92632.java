ASTParser parser = ASTParser.newParser(AST.JLS3);
parser.setKind(ASTParser.K_COMPILATION_UNIT); // you tell parser, that source is whole java file. parser can also process single statements
parser.setSource(source);
CompilationUnit cu = (CompilationUnit) parser.createAST(null); // CompilationUnit here is of type org.eclipse.jdt.core.dom.CompilationUnit  
// source is either char array, like this:

public class A { int i = 9; int j; }".toCharArray()

//org.eclipse.jdt.core.ICompilationUnit type, which represents java source files