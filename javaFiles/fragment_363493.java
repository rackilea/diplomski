int num1 = 0;
try {
    num1 = s.nextInt();
    while (num1 > 3 || num1 < 1) {
        System.out.print("Please enter one of the three available options.\nYour Answer: ");
        num1 = s.nextInt();
    }
} catch (InputMismatchException e) {
    System.out.println("Do not enter a letter/special character");
}