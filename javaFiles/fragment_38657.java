List<Player> players = new ArrayList<Player>();
LinkedList<Card> deck = createDeck(); // This should shuffle too
for (int i = 0; i < playerCount; i++) {
    Player player = new Player();
    players.add(player);
    for (int j = 0; j < 7; j++) {
        player.addCard(deck.removeLast());
    }
}
LinkedList<Card> discards = new LinkedList<Card>();