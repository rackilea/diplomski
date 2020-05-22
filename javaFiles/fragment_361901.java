Double methodName(Object calcOption, Double answer, String ordinal) {
    boolean operandLoop = false;
    while (!operandLoop) {
        System.out.print("Enter " + ordinal + " operand: ");
        String operand = calcOption.next(); // retrieve value
        if (operand.equals("RESULT")) {
            return answer; // If I want to use the previous result as my input
        } else {
            try {
                return Double.parseDouble(operand); // Assumes that if it isn't RESULT, then I'll want to put in a number
            } catch (NumberFormatException nfe) { // necessary if I type anything else in besides RESULT and a double
                throw new RuntimeException("Error: Invalid input! Correct inputs are any real number and \"RESULT\"!");
            }
        }
    }
}