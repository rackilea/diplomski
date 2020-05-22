import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

public class JDTTest
{
    public static void main(String[] args) throws Exception 
    {
        // Set the stage by creating an empty compilation unit and its AST
        ASTParser parser = ASTParser.newParser(AST.JLS8);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setSource("".toCharArray());
        CompilationUnit compilationUnit =
            (CompilationUnit) parser.createAST(null);
        compilationUnit.recordModifications();
        AST ast = compilationUnit.getAST();

        // Create the AST node with the method body. Note that this AST
        // node will belong to a diferent AST!
        ASTNode astNodeWithMethodBody = createAstNodeWithMethodBody();        

        // Create the MethodDeclaration
        MethodDeclaration methodDeclaration = ast.newMethodDeclaration();
        methodDeclaration.setName(ast.newSimpleName("myMethod"));

        // Convert the AST node with the method body to belong to
        // the desired AST, and set it as the method body
        ASTNode convertedAstNodeWithMethodBody = 
            ASTNode.copySubtree(ast, astNodeWithMethodBody);
        Block block = (Block)convertedAstNodeWithMethodBody;
        methodDeclaration.setBody(block);

        // (If necessary: Create a class declaration that will contain the 
        // newly generated method) 
        TypeDeclaration typeDeclaration = ast.newTypeDeclaration();
        typeDeclaration.setName(ast.newSimpleName("Example"));
        typeDeclaration.bodyDeclarations().add(methodDeclaration);
        compilationUnit.types().add(typeDeclaration);

        // Print the resulting document
        Document document = new Document();
        TextEdit edits = compilationUnit.rewrite(document, null);
        edits.apply(document);
        System.out.println(document.get());
    }

    private static ASTNode createAstNodeWithMethodBody()
    {
        String body = "int a = 1;\n int b = 2;\n return (a + b);";
        ASTParser parser = ASTParser.newParser(AST.JLS8);
        parser.setKind(ASTParser.K_STATEMENTS);
        parser.setSource(body.toCharArray());
        ASTNode result = parser.createAST(null);
        return result;
    }

}