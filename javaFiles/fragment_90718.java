import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class JdtDomExample {

    public static void main(String[] args) {

        // (1) somehow get an org.eclipse.jdt.core.dom.CompilationUnit, a TypeDeclaration, and a MethodDeclaration
        AST ast = AST.newAST(AST.JLS8);
        CompilationUnit cu =  ast.newCompilationUnit();
        TypeDeclaration typeDecl = ast.newTypeDeclaration();
        typeDecl.setName(ast.newSimpleName("MyClass"));
        cu.types().add(typeDecl);
        MethodDeclaration method = cu.getAST().newMethodDeclaration();
        method.setName(ast.newSimpleName("myMethod"));
        typeDecl.bodyDeclarations().add(method);

        // (2) create an ASTParser and parse the method body as ASTParser.K_STATEMENTS
        ASTParser parser = ASTParser.newParser(AST.JLS8);
        parser.setSource("System.out.println(\"Hello\" + \" world\");".toCharArray());
        parser.setKind(ASTParser.K_STATEMENTS);
        Block block = (Block) parser.createAST(null);

        // (3) copy the statements to the existing AST
        block = (Block) ASTNode.copySubtree(ast, block);
        method.setBody(block);

        // show the result
        System.out.println(cu);
    }
}