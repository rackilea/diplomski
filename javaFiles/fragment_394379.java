public class GreaterThan implements Predicate<Integer> {
    private final int point;

    public GreaterThan(final int point) {
        this.point = point;
    }

    public boolean test(final Integer incoming) {
        return incoming > point;
    }
}