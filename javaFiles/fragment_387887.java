import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {

    // TODO: Move enum to another file
    public static enum OperatorType {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    public double calculateResult(double operand1, double operand2, OperatorType operator) {
        double result = 0;;
        switch (operator) {
            case ADD:
                result = addValues(operand1, operand2);
                break;
            case DIVIDE:
                result = subtractValues(operand1, operand2);
                break;
            case MULTIPLY:
                result = multiplyValues(operand1, operand2);
                break;
            case SUBTRACT:
                result = subtractValues(operand1, operand2);
                break;
            default:
                break;
        }

        return result;
    }

    public double divideValues(double d1, double d2) {
        double result;
        if (d2 != 0) {
            result = d1 / d2;
        } else {
            // Avoid divide-by-zero error (could also throw it if preferred)
            result = 0;
        }
        return result;
    }

    public double multiplyValues(double d1, double d2) {
        double result = d1 * d2;
        return result;
    }

    public double subtractValues(double d1, double d2) {
        double result = d1 - d2;
        return result;
    }

    public double addValues(double d1, double d2) {
        double result = d1 + d2;
        return result;
    }

    public static void main(String[] args) {
        // Get and validate user input
        String s1 = getInput("Enter a numeric value: ");
        String s2 = getInput("Enter a numeric value: ");
        String op = getInput("Enter 1=ADD, 2=Subtract, 3=Multiply, 4=Divide ");

        // TODO: Handle NumberFormatExceptions here
        double operand1 = Double.parseDouble(s1);
        double operand2 = Double.parseDouble(s2);
        OperatorType operator;

        int opInt = Integer.parseInt(op);
        switch (opInt) {
            case 1:
                operator = OperatorType.ADD;
                break;
            case 2:
                operator = OperatorType.SUBTRACT;
                break;
            case 3:
                operator = OperatorType.MULTIPLY;
                break;
            case 4:
                operator = OperatorType.DIVIDE;
                break;

            default:
                System.out.println("You entered an incorrect value");
                return;
        }

        // Use class to calculate result
        Calculator calculator = new Calculator();
        double result = calculator.calculateResult(operand1, operand2, operator);

        // Output results
        System.out.println("The answer is " + result);
    }

    private static String getInput(String prompt) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(prompt);
        System.out.flush();

        try {
            return stdin.readLine();
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }
}