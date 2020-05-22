double answer;
System.out.println(Operator);
switch (Operator) {
case "+":
    answer = Double.valueOf(Operand1) + Double.valueOf(Operand2);
    break;
case "-":
    answer = Double.valueOf(Operand1) - Double.valueOf(Operand2);
    break;
case "*":
    answer = Double.valueOf(Operand1) * Double.valueOf(Operand2);
    break;
case "/":
    answer = Double.valueOf(Operand1) / Double.valueOf(Operand2);
    break;
}