indexCount = 0;
while (indexCount < wordLength) {
    result = word1.indexOf(guess, indexCount);
    if (result > -1) {
        occurence++;
        indexCount = result + 1; // current occurrence is at index result, so search for
                                 // next occurrence starting at index result + 1
    } else {
        break; // no more occurrences
    }                 
}