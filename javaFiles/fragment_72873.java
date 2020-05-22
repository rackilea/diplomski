public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double inputAmount = 0;
    try {
        do {
            System.out.println("Enter amount:");
            inputAmount = scanner.nextDouble();
        } while (!isValidAmount(inputAmount));
    } catch (Exception e) {
        System.out.println("Input error.");
        scanner.next();
    }
}