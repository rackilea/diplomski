public Computation(Operation operation) {
    this(operation, 0.01);
}

public Computation(Operation operation, double epsilon) {
    this.operation = operation;
    this.epsilon = epsilon;
}