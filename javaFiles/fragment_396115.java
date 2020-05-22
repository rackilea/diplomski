IType declaringType = (IType)methodBinding.getDeclaringClass().getJavaElement();
IMethod methodDeclaration = (IMethod)methodBinding.getMethodDeclaration().getJavaElement();

ICompilationUnit declaringUnit = declaringType.getCompilationUnit();
CompilationUnit unit = parseAST(declaringUnit);
unit.accept(new ASTVisitor() {
    @Override
    public boolean visit(MethodDeclaration node) {
        IMethod method = (IMethod)node.resolveBinding().getJavaElement();
        if (method.equals(methodDeclaration)) {
            ...
        }
        return false;
    }
});