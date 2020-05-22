abstract class AbstractFooRepository implements FooRepository {
    private final FooRepository repo;

    protected AbstractFooRepository(FooRepository repo) {
        this.repo = repo;
    }

    public void save(Foo foo) {
        repo.save(foo);
    }

    // ...
}

public class TimedFooRepository extends AbstractFooRepository {
    // No longer necessary to keep our own handle
    /* private final FooRepository repo; */

    public TimedFooRepository(FooRepository repo, ...) {
        super(repo);
        // ...
    }

    public void save(Foo foo) {
        Timer timer = start();
        try {
            super.save(foo);
        } finally {
            stop(timer);
        }
    }

    // ...
}