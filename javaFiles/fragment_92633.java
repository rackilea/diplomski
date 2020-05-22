cu.accept(new ASTVisitor() {
  public boolean visit(SimpleName node) {
    System.out.println(node); // print all simple names in compilation unit. in our example it would be A, i, j (class name, and then variables)
    return true;
  }
});