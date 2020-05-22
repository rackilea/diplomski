public class LineItem {
    private int quantity;
    private String description;
    private String upc;
    private BigDecimal price; // depending on the accuracy you need, you might be able to get away with double

    // ...

    public String getDescription() {
        return description;
    }

    // ... add more getters to your heart's content ...
}