public boolean calc() {
    guesses = letter;
    if (number <= 7 && counter < 5) {
        if (Secretword.indexOf(letter) != -1) {
            index = Secretword.indexOf(letter);
            System.out.println("You entered a letter in the word");
            counter++;
        } else {
            System.out.println("You entered an incorrect letter");
            number++;
        }
        guesses = guesses + " " + letter;
        System.out.println("The letters you have guessed are:" + guesses);
    }

    String str;
    if (number == 7) {
        System.out.println("You lose");
        return true;
    } else if (counter == 5) {
        System.out.println("You win");
        return true;
    } else {
        return false;
    }
}