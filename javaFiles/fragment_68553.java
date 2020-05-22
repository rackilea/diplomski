@Override
public boolean visit(InfixExpression node) {
    Operator op= node.getOperator();
    if(op.equals(Operator.GREATER) || op.equals(Operator.EQUALS) || ....)
        conditionalInfixExpressionList.add(node);
    return super.visit(node);
}