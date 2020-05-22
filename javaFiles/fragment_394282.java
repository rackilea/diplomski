class Example {

class LazyInitStrategy implements Runnable {
    private final Runnable operation;
    private boolean done = false;

    LazyInitStrategy(Runnable operation) {
        this.operation = operation;
    }

    @Override
    public void run() {
        if (!done) {
            operation.run();
            done = true;
        }
    }
}

private final class AbstractInit implements Runnable {
    public void run() {
        // insert data in db
    }
}

private final class AbstractWebInit implements Runnable {
    public void run() {
        // here, make a call to AbstractTestClass.before() init the interfaces
    }
}

class AbstractTestClass {

    final LazyInitStrategy setup = new LazyInitStrategy(new AbstractInit());

    @Before
    public void before() {
        setup.run();
        // do some more thing
    }
}

class AbstractWebTestClass extends WebTestCase {

    final LazyInitStrategy setupInfo = new LazyInitStrategy(new AbstractWebInit());

    @Before
    public void before() {
        setupInfo.run();
        // do some more thing
    }
}