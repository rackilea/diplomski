while (playAgain == "Y") {
        if (userInput > 0 && userInput < 100) {
            if (userInput == randomInt){
                guesses++;
                System.out.println ("Right! Guesses: " + guesses);
                playAgain = "f";
            }

            else if (userInput < randomInt) {
                guesses++;
                System.out.println ("Your guess was too LOW.");
            }
            else {
                System.out.println ("Your guess was too HIGH.");
                guesses++;
            }
        }
    }
    System.out.println("Would you like to play again?(Y/N)");
    playAgain = scan.next();
}