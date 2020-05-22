public interface Card  {
    int getPower();
    int getValue();
    String getType();
    String getCardName();
    ImageIcon getImage();
}

public class AttackCard implements Card {
    private int power;
    private int value;
    private String type;
    private String cardName;
    private ImageIcon image;

    public AttackCard(int power, int value, String type, String cardName, ImageIcon image);
        this.power = power;
        this.value = value;
        this.type = type;
        this.cardName = cardName;
        this.image = image;
    }

    // Implement methods from Card...
}