private static String getCardAsString2(int i) {
    if (i == 1)
        return "Ace";
    if (i == 11)
        return "Jack";
    if (i == 12)
        return "Queen";
    if (i == 13)
        return "King";
    return String.valueOf(i);// or return null;
}