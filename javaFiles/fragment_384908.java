public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("usage: java Calculator operand1 operator operand2");
      return;
    }
    Integer firstValue;
    Integer secondValue;
    try {
      firstValue = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      System.out.println("Invalid value:" + args[0]);
      return;
    }
    try {
      secondValue = Integer.parseInt(args[2]);
    } catch (NumberFormatException e) {
      System.out.println("Invalid value:" + args[2]);
      return;
    }
    char operator = args[1].charAt(0);
    int result;
    switch (operator) {
      case '+':
        result = Math.addExact(firstValue, secondValue);
        break;
      case '-':
        result = Math.subtractExact(firstValue, secondValue);
        break;
      case '*':
        result = Math.multiplyExact(firstValue, secondValue);
        break;
      case '/':
        result = Math.floorDiv(firstValue, secondValue);
        break;
      default:
        System.out.println("Invalid operator");
        return;
    }
    System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
  }