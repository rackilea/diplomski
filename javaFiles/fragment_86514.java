public class Card {
    String type;

    public Card(String inType) {
        this.type = inType;
    }

    public String toString() {
        return "This is a " + type;
    }
}