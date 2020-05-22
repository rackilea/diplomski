do {
    System.out.print("Please enter an operation: ");
    oper = input.next().charAt(0);
} while (!isValidOperation(oper));

...

public boolean isValidOperation(char oper) {
    return oper == '+' || oper == '*' || oper == '/' || oper == '-' || oper == '%';
}