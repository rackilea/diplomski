do {
    System.out.print("\nWould you like to buy a vowel?: ");
    answer = stdIn.nextLine();

    if ("y".equalsIgnoreCase(answer)) {
        getVowel(stdIn, vGuess); 
    } else if ("n".equalsIgnoreCase(answer)){
        break;
    }
} while (!validAnswer(answer));