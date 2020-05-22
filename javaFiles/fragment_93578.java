public class Supermarket extends LimitedValue {
    private List<SupermarketItem> supermarketItems;

    public Supermarket(List<SupermarketItem> supermarketItems) {
        this.supermarketItems = supermarketItems;
    }

    public List<? extends Item> getItems() {
      return supermarketItems;
    }
}