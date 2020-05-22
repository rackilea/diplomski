public interface ICardVisitor {
    public Card visit(TrumpCard card);
    public Card visit(ColoredCard card);
    public void setSecondCard(ColoredCard card);
    public void setSecondCard(TrumpCard card);
}

public class ComparisonVisitor implements ICardVisitor {
    private TrumpCard trumpCard;
    private ColoredCard coloredCard;
    ...
    //contains comparison logic & instances of card subtypes
}