public final class Mapping {

    private final Function<MyObject, String> getterFunction;
    private final Function<String, String> transformationFunction;
    private final Consumer<String> setterFunction;

    public Mapping(final Function<MyObject, String> getterFunction, final Function<String, String> transformationFunction,
        final Consumer<String> setterFunction) {
        this.getterFunction = getterFunction;
        this.transformationFunction = transformationFunction;
        this.setterFunction = setterFunction;
    }

    // getters
}