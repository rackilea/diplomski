public static void printCards(List<Card> cards) {
    // For each line to be printed
    for(int i = 0; i < Card.TEMPLATE.length; i++) {
        // For each card to be printed
        for(Card card : cards) {
            // Print that line of the card
            System.out.println(String.valueOf(card.getPrintableMatrix()[i])); 
        }
    }
}