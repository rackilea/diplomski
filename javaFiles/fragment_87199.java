static final class Bar implements FooListener<ConcreteFoo> {

    @Override
    public void callback(final ConcreteFoo foo) {
        // TODO Auto-generated method stub

    }

}

static final class ConcreteFoo extends AbstractFoo<ConcreteFoo> {

    protected ConcreteFoo(final Class<? extends FooListener<ConcreteFoo>> listenerClass) {
        super(listenerClass);
    }

    @Override
    protected ConcreteFoo getSelf() {
        return this;
    }

}

static abstract interface FooListener<FOO extends AbstractFoo<FOO>> {

    void callback(FOO abstractFoo);
}

static abstract class AbstractFoo<SELF extends AbstractFoo<SELF>> {

    private final Class<? extends FooListener<SELF>> listenerClass;

    protected AbstractFoo(final Class<? extends FooListener<SELF>> listenerClass) {
        this.listenerClass = listenerClass;
    }

    protected abstract SELF getSelf();

    // Bar might implement FooListener, but I don't control it,
    // so I have no guarantee
    public void externalMethod(final Bar bar) {
        if (listenerClass.isInstance(bar)) {
            final FooListener<SELF> listener = listenerClass.cast(bar);

            listener.callback(getSelf()); // compiles
        }
    }
}