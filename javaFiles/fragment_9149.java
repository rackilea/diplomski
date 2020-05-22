public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String userName = readFieldAndVerify(input, "Enter your name: ");
    String userAddress = readFieldAndVerify(input, "Enter your address: ");
    String userPhoneNumber = readFieldAndVerify(input, "Enter your phone number: ");
}

private static String readFieldAndVerify(Scanner input, String prompt) {
    while (true) {
        System.out.print(prompt);
        String field = input.next();

        System.out.println("Are you sure (yes / no)?");
        String verify = input.next();

        if (verify.equalsIgnoreCase("yes")) {
            System.out.println("Verified!");
            return field;
        } else {
            System.out.println("Canceled");
        }
    }
}