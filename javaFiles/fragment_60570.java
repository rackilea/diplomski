public class Processor {
    private final Set<String> filter;

    public Processor() {
        initialiseFilter();
    }

    private void initialiseFilter() {
        filter = new HashSet<>();
        filter.addAll(Arrays.asList("foo", "bar", "baz"));
    }
}