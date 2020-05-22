abstract class Expression {
}

enum Operator {
    EQ, LT, GT, IN, AND, OR;
}

class BinaryExpression extends Expression {

    private final String field;
    private final Operator op;
    private final String value;

    BinaryExpression(String field, Operator op, String value) {
        this.field = field;
        this.op = op;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + field + " " + op + " " + value + ")";
    }
}

class BooleanExpression extends Expression {

    private final Expression left;
    private final Operator op;
    private final Expression right;

    BooleanExpression(Expression left, Operator op, Expression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left + " " + op + " " + right + ")";
    }
}