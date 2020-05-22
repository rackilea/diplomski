switch (operator) {
    case "+":
        result = num1 + num2;
        System.out.println("The addition result is " + result);
        break;
    case "-":
        result = num1 - num2;
        System.out.println("The subtraction result is " + result);
        break;
    case "-":
        result = num1 * num2;
        System.out.println("The multiplication result is " + result);
        break;
    case "/":
        result = num1 / num2;
        System.out.println("The integer division result is " + result);
        break;
    default:
        throw IllegalArgumentException("Unsupported operator: " + operator);
}