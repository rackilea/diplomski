unit.accept(new ASTVisitor() {

    @Override
    public boolean visit(MethodDeclaration node) {
        Type ownerTypeNode = (Type) node.getParent();
        System.out.println("Found method " + node.getName().getFullyQualifiedName() " + " in type " + ownerTypeNode.getName().getFullyQualifiedName());
    }
});