public int validateScore(Scanner sc) {
    int score = 0;
    System.out.println("Please Enter Student's Score.");
    for (;;) {
        if (!sc.hasNextInt()) {
            System.out.println("Please enter the score and in number");
            sc.next(); // discard
        } else {
            int nextInt = sc.nextInt();
            if (nextInt > 100) {
                System.out.println("Please enter the score and in number in between 0-100 only: ");
            } else if (nextInt < 0) {
                System.out.println("Please enter the score and in number in between 0-100 only: ");
            } else {
                score = nextInt;
                break;
            }
        }
    }
    return score;
}