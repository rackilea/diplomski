public class ReflectionWithClassMap {
    public static void main(String[] args) {
        // this needs to be executed only once
        Map<String, Class<? extends Fruit>> map = createMap();
        // prints "The fruit is red."
        Fruit.printOptional(create(map, "apple"));
        // prints "The fruit is yellow."
        Fruit.printOptional(create(map, "banana"));
    }

    private static Map<String, Class<? extends Fruit>> createMap() {
        Map<String, Class<? extends Fruit>> result = new HashMap<>();
        result.put("apple", Apple.class);
        result.put("banana", Banana.class);
        return result;
    }

    private static Optional<Fruit> create(
            Map<String, Class<? extends Fruit>> map, String userChoice) {
        return Optional.ofNullable(map.get(userChoice))
                       .flatMap(ReflectionWithClassMap::instantiate);
    }

    private static Optional<Fruit> instantiate(Class<? extends Fruit> c) {
        try {
            return Optional.of(c.newInstance());
        } catch (InstantiationException
               | IllegalAccessException e) {
            return Optional.empty();
        }
    }
}