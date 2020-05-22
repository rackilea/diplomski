enum Case implements Function<Object, String> {
    UPPER (o -> o.toString().toUpperCase()),
    LOWER (o -> o.toString().toLowerCase());

    private final Function<Object, String> func;

    private Case(Function<Object, String> func) {
        this.func = func;
    }

    @Override
    public String apply(Object t) {
        return func.apply(t);
    }
}