public static void main(String[] args) throws IOException {
    Scanner keyboard = new Scanner(System.in);
    while (true) {
        int count = 0;
        int a = 1 + (int) (Math.random() * 99);
        int guess = 0;

        System.out.println("Welcome to the Number Guessing Game");
        System.out.print("Guess a number between 0 and 100 or enter -1 to end: ");

        while (guess != a) {
            guess = keyboard.nextInt();
            count++;
            if (guess < 0 || guess > 100) {
                if (guess == -1) {
                    System.out.print("Thank you for playing the game!");
                    System.exit(0);
                }
                System.out.print("Out of bounds. Try Again: ");
                continue;
            }
            if (guess > a) {
                System.out.print("The number is lower. Try again: ");
            } else if (guess < a) {
                System.out.print("The number is higher. Try again: ");
            } else if (guess == a) {
                System.out.println("Congratulations. You guessed the number in "
                        + count + " tries!");
            }
        }
    }
}