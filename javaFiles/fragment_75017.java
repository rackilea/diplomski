guess = console.nextInt();
            if (guess > secretNumber) {
                maximum = guess - 1;
                System.out.print("Enter a number between " + minimum + " and " + maximum + " (inclusive): ");
            }
            if (guess < secretNumber) {
                minimum =guess + 1;
                System.out.print("Enter a number between " + minimum + " and " + maximum + " (inclusive): ");
            }
            if (guess == secretNumber) {
                System.out.println("You win!");
            }