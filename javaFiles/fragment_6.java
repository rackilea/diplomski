int repeatedCount = 0;
getInput : while (incorrect < 7) {
    // ......
    for (int i = 0; i < repeatedCount; i++) {
        if (repeatedLetters[i] == guess) {
            System.out.println("You already guessed " + guess + ".");
            continue getInput;
        }
    }
    repeatedLetters[repeatedCount] = guess; 
    repeatedCount++;