public boolean checkAnswer(int answer) {
    // calculate correct answer
    // do left to right calculation
    int result = questionElements.get(0).getValue();
    for (int elementIndex = 1; elementIndex < questionElements.size(); elementIndex++) {
        Operator op = questionElements.get(elementIndex - 1).getOperator();
        result = op.apply(result, questionElements.get(elementIndex).getValue());
    }

    return answer == result;
}