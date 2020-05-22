public class Sequence {
    private String foo;
    private String bar;
    private String baz;

    // Constructors, getters/setters

    @Override
    public String toString() {
        return String.format("Sequence[foo=%s, bar=%s, baz=%s]", getFoo(),
                getBar(), getBaz());
    }
}

class SequenceHolder {
    private Map<Integer, Sequence> sequence;

    public SequenceHolder() {
        sequence = new TreeMap<Integer, Sequence>();
    }

    // Other constructors, getters/setters
}