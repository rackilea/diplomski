import java.util.Scanner;

public class TopFirst {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIV = "/";

    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {

        do {

            System.out.print("Please enter the first number: ");

            int num1 = readInt();

            System.out.print("Please enter the second number: ");

            int num2 = readInt();

            System.out.print("Please enter an operator: ");

            String operator = readOperator();

            int result = countResult(num1, num2, operator);
            System.out.printf("%d %s %d = %d%n", num1, operator, num2, result);

            System.out.println("Do you want to calculate something else?");

        } while (INPUT.next().equals("yes"));
    }

    private static String readOperator() {
        String operator = INPUT.next();

        if (isCorrect(operator)) {
            return operator;
        } else {
            System.out.print("Incorrect operator, try again: ");
            return readOperator();
        }
    }

    private static int readInt() {
        try {
            return Integer.parseInt(INPUT.next());
        } catch (NumberFormatException e) {
            System.out.print("Incorrect number, try again: ");
            return readInt();
        }
    }

    private static boolean isCorrect(String operator) {
        return MINUS.equals(operator)
            || PLUS.equals(operator)
            || MULTIPLY.equals(operator)
            || DIV.equals(operator);
    }

    private static int countResult(int num1,
                                   int num2,
                                   String operator) {
        switch (operator) {
            case PLUS:
                return num1 + num2;
            case MINUS:
                return num1 - num2;
            case MULTIPLY:
                return num1 * num2;
            case DIV:
                return num1 / num2;
            default:
                return 0;
        }
    }
}