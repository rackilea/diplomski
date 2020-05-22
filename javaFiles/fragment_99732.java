class Problem {
    private String operation;
    private Matrix first;
    private Matrix second;

    public Problem(String operation, Matrix firstMatrix, Matrix secondMatrix) {
        this.operation = operation;
        first = firstMatrix;
        second = secondMatrix;
    }

    public String getOperation() {
        return operation;
    }

    public Matrix getFirst() {
        return first;
    }

    public Matrix getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Problem [\noperation=" + operation + ", \nfirst=" + first + ", \nsecond=" + second + "\n]";
    }
}