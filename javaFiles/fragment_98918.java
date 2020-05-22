public static void main(final String[] args) {
    // get first integer from user
    final Scanner input = new Scanner(System.in);
    System.out.println("Please enter the larger integer: ");
    int I;
    I = input.nextInt();

    // get second integer from user
    System.out.println("Please enter the smaller integer: ");
    int J;
    J = input.nextInt();

    // resolve the issue of zero
    while (J < 1) {
        System.out.println("Can not divide by zero!");
        System.out.println("Please enter new smaller integer: ");
        J = input.nextInt();
    }
    // do the calculations
    while (J != 0) {
        int Remainder;
        Remainder = I % J;
        I = J;
        J = Remainder;
    }
    System.out.println("GCD is" + I);

}