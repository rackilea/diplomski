public class DataUser1Module1 extends PrivateModule {
    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("First")).to("foo");
        bindConstant().annotatedWith(Names.named("Second")).to("bar");

        bind(Data.class);
        bind(DataUser1.class).annotatedWith(Names.named("1")).to(DataUser1.class);

        expose(DataUser1.class).annotatedWith(Names.named("1"));
    }
}

public class DataUser1Module2 extends PrivateModule {
    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("First")).to("foo2");
        bindConstant().annotatedWith(Names.named("Second")).to("bar2");

        bind(Data.class);
        bind(DataUser1.class).annotatedWith(Names.named("2")).to(DataUser1.class);

        expose(DataUser1.class).annotatedWith(Names.named("2"));
    }
}

Injector injector = Guice.createInjector(new DataUser1Module1(), new DataUser1Module2());
DataUser1 dataUser11 = injector.getInstance(Key.get(DataUser1.class, Names.named("1"));
DataUser1 dataUser12 = injector.getInstance(Key.get(DataUser1.class, Names.named("2"));