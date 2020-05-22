enum ExampleEnum {
    A("A's String"), B("B's String"), C("C's String");
    ExampleEnum(String someValue) {
        this.someValue = someValue;
    }

    private final String someValue;

    private static final ExampleEnum[] vals = values();
    private static final List<String> names = Collections.unmodifiableList(
            Stream.of(vals).map(en -> en.someValue).collect(Collectors.toList()));

    public static List<String> getAllValues() {
        return names;
    }
}