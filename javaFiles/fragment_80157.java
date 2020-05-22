public class NoStringCoercionArithmetic extends JexlArithmetic {
    public NoStringCoercionArithmetic(boolean lenient) {
        super(lenient);
    }

    public NoStringCoercionArithmetic() {
        this(false);
    }

    @Override
    public Object add(Object left, Object right) {
        if (left instanceof String || right instanceof String) {
            return left.toString() + right.toString();
        }
        else {
            return super.add(left, right);
        }
    }
}