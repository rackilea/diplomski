if (initialDrawing) {
    Card card;
    for (int i = 0; i < deck.size(); i++) {
        card = deck.get(i);
        card.setY((int) (50 + 0.2 * i));
        card.setX((int) (250 + 0.2 * i));
    }
    initialDrawing = false;
}
for (Card card : deck) {
    card.paintCard(g);
}