PLUS("+", 1) {
    @Override
    public int apply(int operand1, int operand2) {
        return operand1 + operand2;
    }
}, 
// etc.

public abstract int apply(int operand1, int operand2);