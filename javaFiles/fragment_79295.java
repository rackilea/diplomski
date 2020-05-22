public abstract class Card  {
    protected int power;
    protected int value;
    protected String type;
    protected String cardName;
    protected ImageIcon image;

    // You cannot instantiate this directly, only through children.
    public Card(int power, int value, String type, String cardName, ImageIcon image) {
        this.power = power;
        this.value = value;
        this.type = type;
        this.cardName = cardName;
        this.image = image;
    }

    // Getters/Setters...
}

public class AttackCard extends Card {
    public AttackCard(int power, int value, String type, String cardName, ImageIcon image);
        super(power, value, type, cardName, image);
    }
}