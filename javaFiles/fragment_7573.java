IOptimizationFunction opt = new IOptimizationFunction() {

    private static final long serialVersionUID = -5167105656008707046L;

    @Override
    public double evaluate(Object[] params) {
        return (double) params[0] * (double) params[1];
    }
};