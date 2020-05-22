public class SimpleTestBuilder<T> extends TestBuilder<T,T> {
    public SimpleTestBuilder(Class<T> eventClass) {
        super(eventClass, eventClass);
    }
}

public class TestBuilder<T, O> {
    private TestBuilder(Class<T> eventClass, Class<O> observableClass) {
    }
    // ...
}