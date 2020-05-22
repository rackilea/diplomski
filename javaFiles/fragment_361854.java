// No need for this to be @Singleton;
// if you want the same shared Foo instance, make it @Singleton
public class MyFactory {

    private final B.Factory bFactory;
    private final C.Factory cFactory;

    @Inject
    public MyFactory(B.Factory bFactory, C.Factory cFactory) {
        this.bFactory = bFactory;
        this.cFactory = cFactory;
    }

    public A create(final Bar bar) {
        switch (bar.getSomeInteger()) {   // I assume you're checking a
                                          // property of bar
            case 0:
                return bFactory.create(bar);
            case 1:
                return cFactory.create(bar);
            //this goes on
        }
    }
}

public B extends A {
    public interface Factory {
        B create(Bar bar);
    }

    private final Foo foo;

    public B(final Foo foo, @Assisted final Bar bar) {
        super(bar);
        this.foo = foo;
    }
}

public C extends A {
    public interface Factory {
        C create(Bar bar);
    }

    private final Foo foo;

    public C(final Foo foo, @Assisted final Bar bar) {
        super(bar);
        this.foo = foo;
    }
}