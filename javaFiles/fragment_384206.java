public static boolean balancedParentheses(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '[' || c == '(' || c == '{') {
            stack.push(c);
        } else if (c == ']' || c == ')' || c == '}') {
            if (stack.isEmpty() || !matches(stack.pop(), c))
                return false;
        } 
    }
    return stack.isEmpty();
}

private static boolean matches(char opening, char closing) {
    return opening == '{' && closing == '}' ||
            opening == '(' && closing == ')' ||
            opening == '[' && closing == ']';
}