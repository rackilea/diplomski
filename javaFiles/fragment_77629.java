public static void main(String [] args) {
    ICardVisitor cmp = new ComparisonVisitor();
    Card c = new TrumpCard(1);
    Card c2 = new ColoredCard(CardTypes.SPADES,1);
    ICardVisitor cmp = new ComparisonVisitor();
    c.setThisCardAsParameter(cmp);
    Card winningCard = c2.accept(cmp);
}