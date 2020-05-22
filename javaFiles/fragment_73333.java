while (true) {
    System.out.print("Enter the Length of wall 1: ");
    if (scan.hasNextInt()) {
        length1 = scan.nextInt();
        if (1 <= length1 && length1 <= 24) {
            break:
        }
        System.out.println("Error Error");
        System.out.println("Please only enter numbers between 1 and 24.");
    } else {
        System.out.println("Error Error");
        System.out.println("Please only enter numbers.");
        scan.next();
    }
}