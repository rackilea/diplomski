public static void main(String[] args) {
    String operation = user set it
    Operation oper = getOperation(operation);
    oper.execute(3, 4);
}

private static Operation getOperation(String operation) {
    return Operation.valueOf(operation.toUpperCase());
}