for (char letter = 'A' ; letter <= 'Z' ; letter++) {
    int letterIndex = letter - 'A';
    for (int i = 0; i < text.length; i++) {
        if (text[i] == letter) {
            alphabetArray[letterIndex]++;
        }
    }
}