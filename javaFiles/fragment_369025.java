char[][] letters = new char[5][5];
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXY";

for (int i=0; i < letters.length; ++i) {
    for (int j=0; j < letters[i].length; ++j) {
        letters[i][j] = alphabet.charAt(i*letters.length + j);
    }
}