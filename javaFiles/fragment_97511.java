int input = 0;
do {
    System.out.println("Please give a number between: " + MIN + " and " + MAX);
    try {
        input = sc.nextInt();
    }
    catch (InputMismatchException e) {
        System.out.println("That was not a number.  Please try again.");
        input = MIN - 1; // guarantee we go around the loop again
    }
while (input < MIN || input > MAX)