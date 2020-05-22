public class ConsumerFactory {

    private static final Map<String, Consumer<String>> consumers = new HashMap<>();

    public static Consumer<String> getConsumer(String key) {
        if (key != null && consumers.containsKey(key)) {
            return consumers.get(key);
        }
        throw new NoSuchElementException(key);
    }

    public static Consumer<String> addConsumer(String key, Consumer<String> value) {
        return consumers.put(key, value);
    }
}

ConsumerFactory.addConsumer("print", System.out::println);
ConsumerFactory.getConsumer("print").accept("Hello");