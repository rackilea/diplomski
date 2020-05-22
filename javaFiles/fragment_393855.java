static final class TL<T extends IA & IB> extends TypeLiteral<IA> {}

interface IA {}
interface IB {}
static final class Both implements IA, IB {}

@Test
public void test() {
    Injector inj = Guice.createInjector(new M());
    Both object = inj.getInstance(Key.get(new TypeLiteral<Both>(){}));
    assertNotNull(object);
    Foo<Both> foo = inj.getInstance(Key.get(new TypeLiteral<Foo<Both>>() {}));
    assertTrue (object instanceof IA);
    assertTrue (object instanceof IB);
    assertNotNull(foo);
    assertNotNull(foo.obj);
}

static class Foo<T extends IA & IB> {
    private final T obj;
    @Inject
    Foo(T obj) {
        this.obj = obj;
    }
}

static class M extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TL<Both>()).to(Both.class);
    }
}
}