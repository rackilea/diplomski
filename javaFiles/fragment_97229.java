public abstract class UnaryOperation implements Operation {

    /**
     * {@inheritDoc}
     */
    @Override
    public String compose(List<Expression> operands) {
        assert (operands.size() == 1);
        return this.getOperator() + "(" + operands.get(0).getExpression() + ")";
    }

}