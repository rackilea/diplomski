public String toString() {
    String sb = "";
    for (int d = 0; d < words.size(); d++) {
        sb += "The word: " + words.get(d) + System.lineSeparator();
    }
    return sb;
}