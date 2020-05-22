private MethodDeclaration currentMethod = null;

@Override
public void visit(MethodDeclaration n, Void arg) {
    currentMethod = n;
    super.visit(n, arg);
    currentMethod = null;
}

@Override
public void visit(MethodCallExpr n, Void arg) {
    super.visit(n, arg);
    if (currentMethod != null && n.getName().asString().equals("xyz") {
        // Found an invocation of xyz in method this.currentMethod
    }
}