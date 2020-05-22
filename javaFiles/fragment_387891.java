public static Deque<String> infixToPostfix(Deque < String > in) {
    Deque < String > inFix = new ArrayDeque< String >(in );
    Deque < String > postFix = new ArrayDeque < > ();
    Stack< String > storedOperators = new Stack();
    Set< String > allOperators = new HashSet< >
        (Arrays.asList("*", "/", "%", "+", "-", ")", "("));

    for (int i = 0; i < in .size(); i++) {
        if (!allOperators.contains(inFix.peek())) {
            postFix.add(inFix.pop());
        } else if (allOperators.contains(inFix.peek())) {
            if (inFix.peek().equals("(") || storedOperators.size() == 0 && !inFix.peek().equals( ")")) {
                storedOperators.add(inFix.pop());
            } else if (inFix.peek().equals(")")) {
                while (!storedOperators.peek().equals("("))
                    postFix.add(storedOperators.pop());
                if (storedOperators.peek().equals("("))
                    storedOperators.pop();
            } else if (priorityCheck(inFix.peek(), storedOperators.peek())) {
                while (inFix.size() > 0 && storedOperators.size() > 0 && priorityCheck(inFix.peek(), storedOperators.peek()))
                    postFix.add(storedOperators.pop());
                storedOperators.add(inFix.pop());
            } else if (!priorityCheck(inFix.peek(), storedOperators.peek())) {
                storedOperators.add(inFix.pop());
            }
        }
    }

    for (int i = storedOperators.size(); i > 0; i--)
        postFix.add(storedOperators.pop());
    return postFix;
}