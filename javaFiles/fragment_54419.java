ASTParser parser = ASTParser.newParser(AST.JLS8);
Map options = JavaCore.getOptions(); // New!
JavaCore.setComplianceOptions(JavaCore.VERSION_1_5, options); // New!
parser.setCompilerOptions(options); // New!
parser.setSource("import static java.util.Collections.*;".toCharArray());
CompilationUnit cu = (CompilationUnit)parser.createAST(null);
System.err.println(cu); // prints "import static java.util.Collections.*;"