public class RpnCalculator {
    public static Float evaluateInfixExpression(String inflixExpression) {
        Stack<Float> operands = new Stack<>();
        Stack<Operator> operators = new Stack<>();

        for (String token : inflixExpression.split("\\s")) {
            if (isOperator(token)) {
                while (!operators.isEmpty() && operators.peek().hasHigherPrecedenceThan(token))
                    operands.add(eval(operands.pop(), operands.pop(), operators.pop()));
                operators.push(fromString(token));
            } else {
                operands.add(new Float(token));
            }
        }

        while (!operators.isEmpty())
            operands.add(eval(operands.pop(), operands.pop(), operators.pop()));

        return operands.pop();
    }

    private static Float eval(float arg2, float arg1, Operator operator) {
        switch (operator) {
            case ADD:
                return arg1 + arg2;
            case SUBTRACT:
                return arg1 - arg2;
            case MULTIPLY:
                return arg1 * arg2;
            case DIVIDE:
                return arg1 / arg2;
            default:
                throw new IllegalArgumentException("Operator not supported: " + operator);
        }
    }
}