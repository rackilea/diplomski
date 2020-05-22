public class Number implements Expression {

    /**
     * Creates an atomic expression with the specified value.
     * @param value the numeric value
     */
    public Number(double value) {
        super();
        this.value = value;
    }

    /**
     * The numeric value of the number.
     */
    private double value;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getExpression() {
        return String.valueOf(this.value);
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public double getValue() {
        return this.value;
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        ....
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        ....
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLeaf() {
        return true;
    }
}