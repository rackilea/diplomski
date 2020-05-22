public static void main(String... args) {
    Scanner stackScanner = new Scanner("^ 2 - 3 / 2 6 * 8 + 2.5 3");

    Stack<String> stack = new Stack<>();

    while (stackScanner.hasNextLine()) {

        switch (stackScanner.next()) {
            case "+": {
                stack.push("+");
                break;
            }

            case "-": {
                stack.push("-");
                break;
            }

            case "*": {
                stack.push("*");
                break;
            }

            case "/": {
                stack.push("/");
                break;
            }

            case "^": {
                stack.push("^");
                break;
            }
        }

        while (stackScanner.hasNextDouble()) {
            stack.push(Double.toString(stackScanner.nextDouble()));
        }
    }

    System.out.println(stack);
}