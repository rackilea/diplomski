Int input = 0;
try {
    System.out.println("Enter a number :");
    input = scanner.nextInt();
} catch (IOException e) {
    System.err.println("Caught IOException: " + e.getMessage());
    System.out.println("Rewrite the number please");
}