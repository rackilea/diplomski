public class Order {
    private List<Fruit> basket;

    public void addFruitToOrder(Fruit fruit) {
        basket.add(fruit);
    }

    public List<Fruit> getBasket() {
        return basket;
    }
}