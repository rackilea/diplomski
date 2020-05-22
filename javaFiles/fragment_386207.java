try {
    BufferedReader reader = new BufferedReader(new InputStreamReader(
            System.in));
    System.out.println(" Enter the Amount of articles to be ordered.");
    String amount = reader.readLine();

    if (amount.trim().isEmpty()) {
        System.out.println("Amount Entered is Empty");
    }

    if (amount.isEmpty())
        throw new IllegalArgumentException("String is empty.");


    for (int count = 0; count < amount.length(); count++)
        if (!Character.isDigit(amount.charAt(count)))
            throw new IllegalArgumentException("Number format incorrect.");

    order.validateAmount(amount);
} catch (IllegalArgumentException e) {
    System.out.println(e.getMessage() + " Try again.");
}