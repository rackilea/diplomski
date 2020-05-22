public class CosinusOperation extends UnaryOperation {

    /**
     * {@inheritDoc}
     */
    @Override
    public double calculate(List<Expression> operands) {
        assert (operands.size() == 1);
        return Math.cos(operands.get(0).getValue());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getOperator() {
        return "cos";
    }
}