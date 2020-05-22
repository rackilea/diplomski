class TreeGenerator {
    private static final String[] OPERATORS = {"+", "-", "/", "*"};
    private static final int MAX_OPERAND = 100;

    private static Random random = new Random();

    public static Tree full(int depth) {
        if (depth > 1) {
            String operator = OPERATORS[random.nextInt(OPERATORS.length)];
            return new Tree(operator, full(depth - 1), full(depth - 1));
        } else {
            return new Tree(random.nextInt(MAX_OPERAND) + 1);
        }
    }

    public static Tree grow(int depth) {
        if (depth > 1 && random.nextBoolean()) {
            String operator = OPERATORS[random.nextInt(OPERATORS.length)];
            return new Tree(operator, grow(depth - 1), grow(depth - 1));
        } else {
            return new Tree(random.nextInt(MAX_OPERAND) + 1);
        }
    }

}