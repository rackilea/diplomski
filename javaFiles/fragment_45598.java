public static int countUniqueCharacters(String s) {
    String lowerCase = s.toLowerCase();
    char characters[] = lowerCase.toCharArray();
    int countOfUniqueChars = s.length();
    for (int i = 0; i < characters.length; i++) {
        if (i != lowerCase.indexOf(characters[i])) {
            countOfUniqueChars--;
        }
    }
    return countOfUniqueChars;
}