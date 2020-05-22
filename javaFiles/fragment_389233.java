Card cardX = findCardWithNumber(x);
String owner = cardX.getOwner();
for (Card card: allCards) {
    if (card.getOwner().equals(owner)) {
        System.out.println(card);
    }
}