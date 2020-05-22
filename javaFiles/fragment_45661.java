public class ConsumersTest {

    List<String> generate(String input) {
        ArrayList<String> output = new ArrayList<>();
        generators.accept(input, output);
        return output;
    }

    private static <T, U> BiConsumer<T, U> ignoreFirstArg(Consumer<U> consumer) {
        return (t, u) -> consumer.accept(u);
    }

    private final BiConsumer<String, List<String>> generators =
        Stream.<BiConsumer<String, List<String>>>of(
                this::addFirstDependent,
                ignoreFirstArg(this::addSecondIndependent)
        ).reduce(BiConsumer::andThen).orElse((arg1, arg2) -> {});

    private void addFirstDependent(String input, List<String> output) {
        if (input.contains("some string")) {
            output.add("First-Dependent");
        }
    }

    private void addSecondIndependent(List<String> output) {
        output.add("Predefined Output");
    }
}