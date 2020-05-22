for(int i = 0; i < genRadmLetter.length; i++) {
    if(radmWord.charAt(i) == guessedLetter) {
        genRadmLetter[i] = guessedLetter;
        result = true;
    }
}