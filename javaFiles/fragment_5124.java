public boolean matchSearch(String s, String[] searches) {
    for (String search : searches) {
        if (!s.contains(search) return false; // If the word is not in the string FALSE
    }
    return true; // If all words were found in the string, it is a match!
}