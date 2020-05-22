public abstract class Item {
    private final String description;

    public Item(String description) {
        this.description = description;
    }

    public abstract double getPrice();

    public String getDescription() {
        return description;
    }
}