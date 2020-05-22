String[][] letters = new String[5][5];
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXY";

for (int i=0; i < letters.length; ++i) {
    for (int j=0; j < letters[i].length; ++j) {
        char letter = alphabet.charAt(i*letters.length + j);
        if (letter == 'Q') {
            letters[i][j] = letter + "/Z";
        }
        else {
            letters[i][j] = String.valueOf(letter);
        }
    }
}