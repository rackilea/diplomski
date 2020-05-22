public static void main(String[] args) {

    char o;
    String input;
    double num1;
    double num2;
    double result=0.;

    input = JOptionPane.showInputDialog("What is your operand? ");
    o = input.charAt(0);

    while (o!='q') {
        input = JOptionPane.showInputDialog("What is your first number? ");
        num1 = Double.parseDouble(input);
        input = JOptionPane.showInputDialog("What is your second number? ");
        num2 = Double.parseDouble(input);

        if (o == '/') {
            result = num1 / num2;
        } else if (o == '*') {
            result = num1 * num2;
        } else if (o == '+') {
            result = num1 + num2;
        } else if (o == '-') {
            result = num1 - num2;
        } 
        JOptionPane.showMessageDialog(null ,"Your answer is : " + result);

        input = JOptionPane.showInputDialog("What is your operand? ");
        o = input.charAt(0);
    }

}