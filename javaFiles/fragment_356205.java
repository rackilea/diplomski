public class TimedFooRepository implements FooRepository {
    private final FooRepository repo; 

    public void save(Foo foo) {
        Timer timer = start();
        try {
            repo.save(foo);
        } finally {
            stop(timer);
        }
    }

    // ...
}