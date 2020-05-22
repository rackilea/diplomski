public static int postfix(GenericStack<Integer> stack, String[] temp) throws Exception {
    ....
    if (stack.isEmpty()) {
        throw new Exception("No value to return on the following postfix expression: ");
    }
    if (stack.size() > 1) {
        throw new Exception("Too many operands on the following postfix expression: ");
    }
}