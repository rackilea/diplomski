private static int getIntFromUser(Scanner scan) {
    int x = 0;
    while (true) {
        try {
            System.out.println("Enter an integer: ");
            x = scan.nextInt();
            break;
        } catch (InputMismatchException e) {
            scan.next();
        }
    }
    return x;
}