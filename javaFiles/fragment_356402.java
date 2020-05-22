public class DataUser1Module extends PrivateModule {
    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("First")).to("foo");
        bindConstant().annotatedWith(Names.named("Second")).to("bar");

        bind(Data.class);
        bind(DataUser1.class);

        expose(DataUser1.class);
    }
}

public class DataUser2Module extends PrivateModule {
    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("First")).to("foo2");
        bindConstant().annotatedWith(Names.named("Second")).to("bar2");

        bind(Data.class);
        bind(DataUser2.class);

        expose(DataUser2.class);
    }
}

Injector injector = Guice.createInjector(new DataUser1Module(), new DataUser2Module());
DataUser1 dataUser1 = injector.getInstance(DataUser1.class);
DataUser2 dataUser2 = injector.getInstance(DataUser2.class);