guess = console.nextInt();
            if (guess < minimumAllowed || guess > maximumAllowed) {
                // handle error
                continue;
            }
            // handle valid input
            if (guess > secretNumber) {        
                // ...
            }
            if (guess < secretNumber) {
                // ...
            }
            if (guess == secretNumber) {
                // ...
            }