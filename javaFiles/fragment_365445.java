public class MyServiceMock implements MyService {
    private final BehaviorDelegate<MyService> delegate;

    public MyServiceMock(BehaviorDelegate<MyService> delegate) {
        this.delegate = delegate;
    }

    public Observable<String> name() {
        return delegate.returningResponse("test").name();
    }
}