public class ItemRegister  {
    Stock stock;
    public ItemRegister(Stock stock) {
        this.stock = stock;
    }

    public void registerItem(String name, double price) {
        stock.getStock().add(new Item(setItemCode(), name, price, 0));
    }

    private int setItemCode() {
        return stock.getStock().size() + 1;
    }
}