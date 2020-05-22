public class ParensExpession extends JExpressionImpl{

    private JExpression expression;

    public ParensExpession(JExpression expression) {
        this.expression = expression;
    }

    @Override
    public void generate(JFormatter formatter) {
        formatter.p('(').g(expression).p(')');
    }
}