JLabel[] cards = new JLabel[5];
for (int i = 0; i < cards.length; i++) {
    JLabel label = new JLabel(CARD_BACK);
    label.setBounds(60*i, 0, 150, 215);
    auxHands.add(label);
    cards[i] = label;
}