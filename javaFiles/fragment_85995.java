public boolean checkAnswer(int answer) {
    // calculate correct answer
    // use shunting yard algorithm
    Deque<Integer> outputQueue = new ArrayDeque<>();
    Deque<Operator> operatorStack = new ArrayDeque<>();
    for (QuestionElement element : questionElements) {
        outputQueue.push(element.getValue());
        Operator op = element.getOperator();
        if (op != null) {
            while (!operatorStack.isEmpty() && op.getPrecedence() <= operatorStack.peek().getPrecedence()) {
                int operand2 = outputQueue.pop();
                int operand1 = outputQueue.pop();
                outputQueue.push(operatorStack.pop().apply(operand1, operand2));
            }
            operatorStack.push(op);
        }
    }
    while (!operatorStack.isEmpty()) {
        int operand2 = outputQueue.pop();
        int operand1 = outputQueue.pop();
        outputQueue.push(operatorStack.pop().apply(operand1, operand2));
    }
    int result = outputQueue.pop();
    assert outputQueue.isEmpty();

    return answer == result;
}