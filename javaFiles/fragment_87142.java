register(new AbstractBinder(){
    @Override
    public void configure() {
        bind(Foo1Impl.class).named("foo1").to(Foo.class);
        bind(Foo2Impl.class).named("foo2").to(Foo.class);
    }
});