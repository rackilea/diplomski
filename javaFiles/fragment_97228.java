public class PlusOperation extends BinaryOperation {

    /**
     * {@inheritDoc}
     */
    @Override
    public double calculate(List<Expression> operands) {
        assert (operands.size() == 2);
        return operands.get(0).getValue() + operands.get(1).getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getOperator() {
        return "+";
    }

}