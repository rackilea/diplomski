public interface FooFactory {
    Foo create(Baz baz);
}

//...

install(new FactoryModuleBuilder()
    .implement(Foo.class, AssistedFoo.class)
    .build(FooFactory.class));