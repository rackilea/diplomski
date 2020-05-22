public void processJavaFile(File file) {
    String source = FileUtils.readFileToString(file);
    Document document = new Document(source);
    ASTParser parser = ASTParser.newParser(AST.JLS3);
    parser.setSource(document.get().toCharArray());
    CompilationUnit unit = (CompilationUnit)parser.createAST(null);
    unit.recordModifications();

    // to get the imports from the file
    List<ImportDeclaration> imports = unit.imports();
    for (ImportDeclaration i : imports) {
        System.out.println(i.getName().getFullyQualifiedName());
    }

    // to create a new import
    AST ast = unit.getAST();
    ImportDeclaration id = ast.newImportDeclaration();
    String classToImport = "path.to.some.class";
    id.setName(ast.newName(classToImport.split("\\.")));
    unit.imports().add(id); // add import declaration at end

    // to save the changed file
    TextEdit edits = unit.rewrite(document, null);
    edits.apply(document);
    FileUtils.writeStringToFile(file, document.get());

    // to iterate through methods
    List<AbstractTypeDeclaration> types = unit.types();
    for (AbstractTypeDeclaration type : types) {
        if (type.getNodeType() == ASTNode.TYPE_DECLARATION) {
            // Class def found
            List<BodyDeclaration> bodies = type.bodyDeclarations();
            for (BodyDeclaration body : bodies) {
                if (body.getNodeType() == ASTNode.METHOD_DECLARATION) {
                    MethodDeclaration method = (MethodDeclaration)body;
                    System.out.println("name: " + method.getName().getFullyQualifiedName());
                }
            }
        }
    }
}