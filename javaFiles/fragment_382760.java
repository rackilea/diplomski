public enum Fruit {
    APPLE,
    ORANGE,
    BANANA
}

public class Dessert {

    private Fruit fruit;

    public Dessert(Fruit fruit) {
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }
}

public class Test {

    Dessert dessert = new Dessert(Fruit.APPLE);
    if (dessert.getFruit() == Fruit.ORANGE) {
        // nope
    } else if (dessert.getFruit() == Fruit.APPLE) {
        // yep
    }
}