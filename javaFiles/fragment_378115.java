int last = 0;
for(int y = 0; y < genRadmLetter.length; y++) {
    int pos = radmWord.indexOf(guessedLetter, last);

    if(pos > -1) {
        genRadmLetter[pos] = guessedLetter; // use found index to replace
        result = true;

        last = pos + 1; // skip to the next letter
    }
    if(pos == radmWord.length() - 1) {
        break; // it was the last letter
    }
}