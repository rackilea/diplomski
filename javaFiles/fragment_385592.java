public class AbstractFactory {
    public static void main(String[] args) {
        // this needs to be executed only once
        Map<String, Supplier<Fruit>> map = createMap();
        // prints "The fruit is red."
        Fruit.printOptional(create(map, "apple"));
        // prints "The fruit is yellow."
        Fruit.printOptional(create(map, "banana"));
    }

    private static Map<String, Supplier<Fruit>> createMap() {
        Map<String, Supplier<Fruit>> result = new HashMap<>();
        result.put("apple", Apple::new);
        result.put("banana", Banana::new);
        return result;
    }

    private static Optional<Fruit> create(
            Map<String, Supplier<Fruit>> map, String userChoice) {
        return Optional.ofNullable(map.get(userChoice))
                       .map(Supplier::get);
    }
}