public static void main(String[] args) {
    double input = 2.12345;
    String stringInput = String.valueOf(input);
    String withoutDot = stringInput.replace(".", "");

    try {
        int number = Integer.parseInt(withoutDot);
    }
    catch (NumberFormatException e) {
        // Handle this exception gracefully
    }
}