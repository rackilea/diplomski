public class Reflection {
    public static void main(String[] args) {
        // prints "The fruit is red."
        Fruit.printOptional(create("stackoverflow.fruit.Apple"));
        // prints "The fruit is yellow."
        Fruit.printOptional(create("stackoverflow.fruit.Banana"));
    }

    private static Optional<Fruit> create(String userChoice) {
        try {
            return Optional.of((Fruit) Class.forName(userChoice).newInstance());
        } catch (InstantiationException
               | IllegalAccessException
               | ClassNotFoundException e) {
            return Optional.empty();
        }
    }
}