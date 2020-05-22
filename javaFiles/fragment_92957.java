public static void printCards(List<Card> cards) {
    // Print the first line
    for(Card card : cards) System.out.print("┌────┐ ");
    System.out.println();

    // Print the second line
    for(Card card : cards) System.out.print("│%s   │ ", card.getPrintableValue());
    System.out.println();

    // ... and so on
}