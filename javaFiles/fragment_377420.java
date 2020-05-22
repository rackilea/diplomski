char operator = '*';
int leftNumber = 5;
int rightNumber = 9;

switch (operator) {
    case '+': System.out.println(leftNumber + rightNumber);
              break;
    case '-': System.out.println(leftNumber - rightNumber);
              break;
    case '*': System.out.println(leftNumber * rightNumber);
              break;
    case '/': System.out.println(leftNumber / rightNumber);
              break;
    case '^': System.out.println(Math.pow(leftNumber, rightNumber));
              break;
    default:  System.out.println("Unknown operator");
}