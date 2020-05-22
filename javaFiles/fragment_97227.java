public abstract class BinaryOperation implements Operation {

    /**
     * {@inheritDoc}
     */
    @Override
    public String compose(List<Expression> operands) {
        assert (operands.size() == 2);

        final Expression op1 = operands.get(0);
        final Expression op2 = operands.get(1);
        final boolean op1Leaf = op1.isLeaf();
        final boolean op2Leaf = op2.isLeaf();
        final StringBuilder builder = new StringBuilder();
        if (!op1Leaf) {
            builder.append("(");
        }
        builder.append(op1.getExpression());
        if (!op1Leaf) {
            builder.append(")");
        }
        builder.append(this.getOperator());
        if (!op2Leaf) {
            builder.append("(");
        }
        builder.append(op2.getExpression());
        if (!op2Leaf) {
            builder.append(")");
        }
        return builder.toString();
    }
}