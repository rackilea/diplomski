double n = input.nextDouble();
double guess = n / 2;

double pctDiff = Double.MAX_VALUE;
double lastGuess = guess;

    while (Math.abs(pctDiff) >= 0.01)
    {                        
        double r = n / guess;
        guess = (guess + r) / 2;
        pctDiff = ((guess-lastGuess)/lastGuess); // normally, multiply by 100, but don't need to necessarily...
        lastGuess = guess;
        System.out.println(guess);

    }