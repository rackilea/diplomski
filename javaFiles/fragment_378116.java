int pos = 0;
do {
    pos = radmWord.indexOf(guessedLetter, pos);

    if(pos > -1) {
        genRadmLetter[pos] = guessedLetter;
        result = true;
        pos++;
    }
} while(pos > -1 && pos < radmWord.length());