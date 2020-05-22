public static String searchAndReplace(String phrase, String searchWord, String replaceWord) {
    int findIndex = phrase.indexOf(searchWord);

    while (findIndex >= 0) {
        phrase = phrase.substring(0, findIndex) + replaceWord + phrase.substring(findIndex + searchWord.length());

        findIndex = phrase.indexOf(searchWord);
    }
    return phrase;
}