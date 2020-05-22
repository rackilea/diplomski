public enum Operation {
ADD {
    int execute(int a, int b) {
        return a + b;
    }
},
SUB {
    int execute(int a, int b) {
        return a - b;
    }
},
MUL {
    @Override
    int execute(int a, int b) {
        return a * b;
    }
},
DIV {
    @Override
    int execute(int a, int b) {
        return a / b;
    }
};

abstract int execute(int a, int b);

public static void main(String[] args) {
    Operation oper = getOperation();
    oper.execute(3, 4);
}

private static Operation getOperation() {
    return Operation.MUL;
}