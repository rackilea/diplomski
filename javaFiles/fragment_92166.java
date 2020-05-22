public abstract class Point<P extends Point<P>> {
    public abstract P[] neighbors();
    public void commonMethod() { /* ... */ }
}

public class SimplePoint extends Point<SimplePoint> { /* ... */ }

public class SpecialPoint extends Point<SpecialPoint> { /* ... */ }