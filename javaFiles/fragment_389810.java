public final class ParenthesisCreator implements Function<String, String> {
    private final IntPredicate isOperator;

    public ParenthesisCreator() {
        this(ch -> ch == '/' || ch == '*' || ch == '+' || ch == '-');
    }

    public ParenthesisCreator(IntPredicate isOperator) {
        this.isOperator = isOperator;
    }

    @Override
    public String apply(String expr) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder buf = null;

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == ')') {
                if (buf != null) {
                    stack.push(buf.insert(0, '(').append(')').toString());
                    buf = null;
                } else if (stack.size() >= 2) {
                    String two = stack.pop();
                    String one = stack.pop();
                    stack.push('(' + one + two + ')');
                } else
                    throw new IllegalArgumentException();
            } else if (isOperator.test(ch) && buf == null && !stack.isEmpty())
                stack.push(stack.pop() + ch);
            else
                (buf = buf == null ? new StringBuilder() : buf).append(ch);
        }

        return String.join("", stack);
    }
}