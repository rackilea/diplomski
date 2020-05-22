public static void main(String[] args) throws Exception {
    List<String> cardLines = Files.readAllLines(Paths.get(yourCardFile));

    // Build your card objects from the file
    List<Card> cards = new ArrayList<>();
    for (int i = 0; i < cardLines.size(); i += 2) {
        cards.add(new Card(cardLines.get(i), cardLines.get(i + 1)));
    }

    // Print the cards out
    for (Card card : cards) {
        System.out.println(card);
    }

    // Do what you need to do after you have your cards
}

public static class Card {
    public String number;
    public String suit;

    public Card(String n, String s) {
        number = n;
        suit = s;
    }

    @Override
    public String toString() {
        return number + suit;
    }
}