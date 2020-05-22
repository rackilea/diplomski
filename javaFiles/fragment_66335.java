private static boolean isVowel(char c) {
    switch (c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
            return true;
        default: return false;
    }
}

public static String reverseVowels(String s) {
    final char [] sArray = s.toCharArray();
    final StringBuilder reversedString = new StringBuilder();
    final StringBuilder vowels = new StringBuilder();

    int vowelIndex = -1;
    for (char c : sArray) {
        if (isVowel(c)) {
            vowels.append(c);
            ++vowelIndex;
        }
    }

    for (char c : sArray) {
        if (isVowel(c))
            c = vowels.charAt(vowelIndex--);

        reversedString.append(c);
    }
    return reversedString.toString();
}