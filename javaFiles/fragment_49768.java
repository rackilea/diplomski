class Visitor {
  boolean indexingExpected;
  void startIteratedExpression() {
    indexingExpected = true;
  }
  void doIndexing() {
    indexingExpected = false;
  }
  void someOtherVisit() {
    if (indexingExpected) {
      throw IllegalStateException();
    }
  }
}
clas IteratedExpression {
  private List<Expression> children;
  public void visit(Visitor visitor) {
    visitor.startIteratedExpression();
    for(Expression child : childrenExpression) {
      child.visit(visitor);
    }
    visitor.endIteratedExpression();
  }
}
class IndexingExpression extends Expression {
  public void visit(Visitor visit) {
    visitor.doIndexing();
  }
}