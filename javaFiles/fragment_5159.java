public static int consecutiveVowelsInLine(String line) {
    int longestVowels = 0;
    int candidateLength = 0;
    char vowel = 'b'; //b is not a vowel
    for (int i = 0; i < line.length(); i++) {
        char ci = line.charAt(i);
        if (isVowel(ci)) {
            if (ci == vowel) { //the same as the other one
                candidateLength++;
            } else {
                candidateLength = 1;
            }
            vowel = ci;
        } else {
            candidateLength = 0;
            vowel = 'b';
        }
        longestVowels = Math.max(longestVowels, candidateLength);
    }
    return longestVowels;
}