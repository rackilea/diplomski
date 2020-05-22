for (int i = 0; i < sbParagraph.length(); i++) {
    char c = defParagraph.toLowerCase().charAt(i);
    boolean isVowel = false;
    for (int j = 0; j < vowels.length; j++) {
        if (c == vowels[j]) {
            isVowel = true;
            break;
        }
    }
    if (isVowel) {
        vowelCount++;
    } else {
        vowParagraph.append(c);
    }
}