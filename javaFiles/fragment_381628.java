public interface Orange {
    // Looks up id and returns the corresponding Priority.
    public int getPriority(Long id);
}

public class Foo {
    public static Comparator<Long> getComparator(final Orange orange) {
        return new Comparator<Long>() {
            public int compare(Long id1, Long id2) {
                // Get priority through orange, or
                // Make orange juice from our orange.
                // You may want to compare them in a different way.
                return orange.getPriority(id1) - orange.getPriority(id2);
        };
    }
}