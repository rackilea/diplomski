interface DelegatorVisitorA extends VisitorA {
  VisitorA getVisitorA();  

  default void visit(AST_A1 node) {
    getVisitorA().visit(node);
  }
  ...
  default void visit(AST_A49 node) {
    getVisitorA().visit(node);
  }
}