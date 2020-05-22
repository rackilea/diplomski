String numbers = scanner.next();
if (numbers.matches("(\\d{7}|\\d{10})$")) {
    int mobile = Integer.valueOf(numbers);
    System.out.println("valid");
} else {
    System.out.println("Not valid");
}