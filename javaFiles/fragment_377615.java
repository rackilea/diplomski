public class ExampleClass {
    private static final Random random = new Random();

    public ExampleClass() {
        System.out.println("Constructor using random: " + random.nextInt(100));
    }

    public void methodThatUsesRandom() {
        System.out.println("Method using random: " + random.nextInt(100));
    }
}