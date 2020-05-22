interface DelegatorVisitorC extends VisitorC {
  VisitorA getVisitorA();
  default void visit(AST_A1 node) {
    getVisitorA().visit(node);
  }
  ...
  default void visit(AST_A49 node) {
    getVisitorA().visit(node);
  }
  VisitorB getVisitorB();  
  default void visit(AST_B1 node) {
    getVisitorB().visit(node);
  }
  ...
  default void visit(AST_B49 node) {
    getVisitorB().visit(node);
  }
  VisitorC getVisitorC();  
  default void visit(AST_C1 node) {
    getVisitorC().visit(node);
  }
  ...
  default void visit(AST_C49 node) {
    getVisitorC().visit(node);
  }
}