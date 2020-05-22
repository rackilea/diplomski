public class ReflectionWithMap {
    public static void main(String[] args) {
        // this needs to be executed only once
        Map<String, String> map = createMap();
        // prints "The fruit is red."
        Fruit.printOptional(create(map, "apple"));
        // prints "The fruit is yellow."
        Fruit.printOptional(create(map, "banana"));
    }

    private static Map<String, String> createMap() {
        Map<String, String> result = new HashMap<>();
        result.put("apple", "stackoverflow.fruit.Apple");
        result.put("banana", "stackoverflow.fruit.Banana");
        return result;
    }

    private static Optional<Fruit> create(
            Map<String, String> map, String userChoice) {
        return Optional.ofNullable(map.get(userChoice))
                       .flatMap(ReflectionWithMap::instantiate);
    }

    private static Optional<Fruit> instantiate(String userChoice) {
        try {
            return Optional.of((Fruit) Class.forName(userChoice).newInstance());
        } catch (InstantiationException
               | IllegalAccessException
               | ClassNotFoundException e) {
            return Optional.empty();
        }
    }
}