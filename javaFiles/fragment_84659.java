public class Parser<T> {
    public static final BiConsumer<Object,Object> IGNORE = (x,y) -> {};

    private final Supplier<? extends T> instantiator;
    private final List<BiConsumer<? super T, ? super String>> setters;

    public Parser(Supplier<? extends T> instantiator,
                  List<BiConsumer<? super T, ? super String>> setters) {
        this.instantiator = Objects.requireNonNull(instantiator);
        this.setters = new ArrayList<>(setters);
        if(this.setters.contains(null)) throw new NullPointerException();
    }
    public Parser(Supplier<? extends T> instantiator,
                  BiConsumer<? super T, ? super String>... setters) {
        this(instantiator, Arrays.asList(setters));
    }

    // Replace the two-dimensional string array with actual xls parsing...
    public List<T> parse(String[][] data) {
        List<T> result = new ArrayList<>(data.length);
        for(String[] row: data) {
            T instance = instantiator.get();
            for (int ix = 0; ix < row.length; ix++)
                setters.get(ix).accept(instance, row[ix]);
            result.add(instance);
        }
        return result;
    }
}