enum Operation { //could/should implement IOperation
    ADD((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b);

    private IOperation operation;

    Operation(IOperation operation) {
        this.operation = operation;
    }

    public final int performOn(int firstValue, int secondValue) {
        return operation.performOn(firstValue, secondValue);
    }
}

interface IOperation {
    int performOn(int firstValue, int secondValue);
}