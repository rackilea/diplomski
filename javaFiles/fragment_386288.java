while (!inputStack.empty()) {
    String next = inputStack.pop();
    System.out.println(next);  // just to make sure it's reading correctly
    if (!isOperator(next)) {
       ...
    }
    // ... rest of your code goes here
}