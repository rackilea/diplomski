public static void main(String args[]) throws IOException {

    Console c = System.console();
    if (c == null) {
        System.err.println("No console.");
        System.exit(1);
    }

    boolean isValidResponse = false;
    do {
        String response = c.readLine("Are you ready to continue? (Enter \"YES\" or \"NO\"): ");
        switch (response.toUpperCase()) {
            case "YES":
                isValidResponse = true;
                System.out.println("Let's continue!");
                break;
            case "NO":
                isValidResponse = true;
                System.out.println("Goodbye!");
                break;
            default:
                isValidResponse = false;
                System.out.println("Please input a correct response!");
                break;
        }
    } while (!isValidResponse);
}