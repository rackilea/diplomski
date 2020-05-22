char operator;
do {
  char operator = scanner.next().get(0);
  if(!isValidOperator(operator)) {
    System.out.println("invalid operator");
  }
}while(!isValidOperator(operator))

public boolean isValidOperator(char operator) {
  if(operator == '+') {
    return true;
  } else if (operator == '-') {
    return true;
  }

  return false;
}