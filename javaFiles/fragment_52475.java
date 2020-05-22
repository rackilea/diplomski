public boolean visit(FieldDeclaration node) {
    System.out.println("field declaration: " + node);
    return true;
}

public boolean visit(VariableDeclarationStatement node) {
    System.out.println("variable declaration: " + node);
    return true;
}