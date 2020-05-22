static class Bar implements FooListener<ConcreteFoo, Bar> {

    @Override
    public void callback(final ConcreteFoo foo) {
        // TODO Auto-generated method stub

    }

}

static class ConcreteFoo2 extends AbstractFoo<ConcreteFoo, Bar> {

    protected ConcreteFoo2(final Class<Bar> listenerClass) {
        super(listenerClass);
    }

}

static class ConcreteFoo extends AbstractFoo<ConcreteFoo, Bar> {

    protected ConcreteFoo(final Class<Bar> listenerClass) {
        super(listenerClass);
    }

}