for (int i = 0; i < 2; i++) {
    boolean operandLoop = false;
    while (!operandLoop) {
        System.out.print("Enter " + arr[i] + " operand: ");
        operand = calcOption.next(); // retrieve value
        if (operand.equals("RESULT")) {
            var[i] = answer; // If I want to use the previous result as my input
            operandLoop = true;
        } else {
            try {
                var[i] = Double.parseDouble(operand); // Assumes that if it isn't RESULT, then I'll want to put in a number
                operandLoop = true;
            } catch (NumberFormatException nfe) { // necessary if I type anything else in besides RESULT and a double
                System.out.print("Error: Invalid input! Correct inputs are any real number and \"RESULT\"!");
            }
        }
    }
}