private static int weighWord(String str) {
    int weight = 0;
    for (char ch : str.toCharArray()) {
        weight += getLetterWeight(ch);
    }
    return weight;
}