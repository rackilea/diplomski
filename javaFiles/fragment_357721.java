Scanner scanner = new Scanner(expression);
while (scanner.hasNext()) {                     // while there more input...
    if (scanner.hasNextInt()) {                 // is the next token an int?
        int number = scanner.nextInt();         // read the next token as an integer
        op.push(number);
    } else {                                    // the next token is NOT an int
        String operator = scanner.next();       // read the next token as a String
        if (operator.equals("+")) {
            // same as before
        } else if (operator.equals("-")) {
            // same as before
        } else if (operator.equals("*")) {
            // same as before
        } else if (operator.equals("/")) {
            // same as before
        }
    }
}