package de.scrum_master.stackoverflow;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TensComplementArithmetic {
    // Print debug messages?
    private static final boolean DEBUG = true;

    // Maximum length for numbers entered by a user
    // (number of digits excluding the optional +/- sign)
    private static final int MAX_NUMBER_LENGTH = 50;

    // Array must have one additional element for the sign and
    // one more to avoid overflows when adding big negative numbers
    private static final int ARRAY_LENGTH = MAX_NUMBER_LENGTH + 2;

    // Scanner for console input handling
    private static final Scanner INPUT_SCANNER = new Scanner(System.in);

    // Regex pattern for positive/negative integer number format verification incl. length check
    private static final Pattern INTEGER_PATTERN = Pattern.compile("[+-]?[0-9]{1," + MAX_NUMBER_LENGTH + "}");

    // Regex pattern for operator verification (currently only "+"/"-" allowed)
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+-]");

    // The number 1 is always needed for converting a 9's into a 10's complement
    // during negation, so we define it as a reusable constant
    private static final int[] NUMBER_ONE;

    static {
        // Initialise constant carrying array representation for number 1
        NUMBER_ONE = new int[ARRAY_LENGTH];
        NUMBER_ONE[ARRAY_LENGTH - 1] = 1;
    }

    public static String readConsoleInput(String prompt, Pattern validationPattern, String errorMessage) {
        String input = null;
        while (input == null) {
            System.out.print(prompt + ": ");
            if (INPUT_SCANNER.hasNext(validationPattern))
                input = INPUT_SCANNER.next(validationPattern);
            else {
                INPUT_SCANNER.nextLine();
                System.out.println(errorMessage);
            }
        }
        return input;
    }

    public static String getOperand(String operandName) {
        return readConsoleInput(
            "Operand " + operandName,
            INTEGER_PATTERN,
            "Illegal number format, please enter a positive/negative integer of max. " + MAX_NUMBER_LENGTH + " digits."
        );
    }

    private static String getOperator() {
        return readConsoleInput(
            "Arithmetical operator (+ or -)",
            OPERATOR_PATTERN,
            "Unknown operator, try again."
        );
    }

    public static int[] parseInteger(String number) {
        char sign = number.charAt(0);
        boolean isNegative = sign == '-' ? true : false;
        if (isNegative || sign == '+')
            number = number.substring(1);

        int[] result = new int[ARRAY_LENGTH];
        int parsePosition = number.length() - 1;
        for (int i = result.length - 1; i >= 0; i--) {
            if (parsePosition < 0)
                break;
            result[i] = number.charAt(parsePosition--) - '0';
        }
        return isNegative ? negate(result) : result;
    }

    public static int[] add(int[] operand1, int[] operand2) {
        int[] result = new int[ARRAY_LENGTH];
        int carry = 0;

        for (int i = ARRAY_LENGTH - 1; i >= 0; i--) {
            result[i] = operand1[i] + operand2[i] + carry;
            if (result[i] >= 10) {
                result[i] = result[i] % 10;
                carry = 1;
            } else
                carry = 0;
        }
        return result;
    }

    public static int[] complement(int[] operand) {
        int[] result = new int[ARRAY_LENGTH];

        for (int i = operand.length - 1; i >= 0; i--)
            result[i] = 9 - operand[i];
        return result;
    }

    public static int[] negate(int[] operand) {
        return add(complement(operand), NUMBER_ONE);
    }

    public static void print(int[] result, String operation) {
        System.out.print(operation.charAt(0) == '-' ? "Difference = " : "Sum = ");
        if (result[0] == 9) {
            result = negate(result);
            System.out.print("-");
        }
        boolean leadingZero = true;
        for (int i = 0; i < result.length; i++) {
            if (leadingZero) {
                if (result[i] == 0)
                    continue;
                leadingZero = false;
            }
            System.out.print(result[i]);
        }
        System.out.println(leadingZero ? "0" : "");
    }

    public static void main(String[] args) {
        int[] operand1 = parseInteger(getOperand("#1"));
        int[] operand2 = parseInteger(getOperand("#2"));
        String operator = getOperator();

        if (operator.equals("-"))
            operand2 = negate(operand2);

        int[] result = new int[ARRAY_LENGTH];
        result = add(operand1, operand2);
        if (DEBUG) {
            System.out.println("Operand #1 = " + Arrays.toString(operand1));
            System.out.println("Operand #2 = " + Arrays.toString(operand2));
            System.out.println("Result     = " + Arrays.toString(result));
        }
        print(result, operator);
    }
}