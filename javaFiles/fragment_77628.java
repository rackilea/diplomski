public Card accept(ICardVisitor visitor) {
    return visitor.visit(this);
}

public void setThisCardAsParameter(ICardVisitor v) {
    v.setSecondCard(this);
}