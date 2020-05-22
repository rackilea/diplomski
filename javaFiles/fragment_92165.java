public interface Point<P extends Point<P>> {
    P[] neighbors();
}

public class SimplePoint implements Point<SimplePoint> {
    @Override
    public SimplePoint[] neighbors() { /* ... */ }
}

public class SpecialPoint implements Point<SpecialPoint> {
    @Override
    public SpecialPoint[] neighbors() { /* ... */ }
}