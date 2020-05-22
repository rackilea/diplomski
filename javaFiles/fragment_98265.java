public static void main(String[] args) {
    // ...
    String card1s = getCardAsString(first);
    // ...
    if ((first >= 11) || (first == 1))
    System.out.println("The first card is:  " + card1s + first);
}

private static String getCardAsString(int i) {
    switch (i) {
    case 1:
        return "Ace";
    case 11:
        return "Jack";
    case 12:
        return "Queen";
    case 13:
        return "King";
    default:
        return String.valueOf(i); // or return null; not sure what you need
    }
}