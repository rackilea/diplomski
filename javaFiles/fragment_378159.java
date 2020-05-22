interface DelegatorVisitorB extends VisitorB , DelegatorVisitorA{
  VisitorB getVisitorB();
  default void visit(AST_B1 node) {
    getVisitorB().visit(node);
  }
  ...
  default void visit(AST_B49 node) {
    getVisitorB().visit(node);
  }
}