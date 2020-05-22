public class BinaryPlusOperator implements IntBinaryOperator {

    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }

    @Override
    public String toString() {
        return "+";
    }

}