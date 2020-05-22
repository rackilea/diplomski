String operator = input.next();
if(operator == null || operator.isEmpty()) {
   return;
}
int answer = 0;
switch (operator.charAt(0)) {
    case '+':
        answer = Add(userInput1, userInput2);
        break;
    case '*':
        answer = Multiply(userInput1, userInput2);
        break;
    ...