for (int i=0; i < sentence2.length(); i++) {
    boolean vowel = false;
    for (int j = 0; j < lookout.length; j++) {
        if (sentence2.charAt(i) == lookout[j]) {
            vowel = true;
            vowels++;
            break; //A vowel is found
        }
    }
    if (!vowel && Character.isLetter(sentence2.charAt(i))) {
        consonants++;
    }
}