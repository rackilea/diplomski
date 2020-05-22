interface Parser<T> {

    T parse();
}

static void populateMap(Map<String, T> map, Parser<T> parser) { ... }

...

Map<String, MyClass<?>> m = new HashMap<>();
Parser<MyClass<?>> myClassParser = new Parser<MyClass<?>>() {
    @Override
    public MyClass<?> parse() {
        return parse(..., MyClass.class);
    }
};
populateMap(m, myClassParser);