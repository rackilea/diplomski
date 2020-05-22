@Component
class MultiProvider {
    @Bean(destroyMethodName="cleanup")      // HERE IS THE TRICK
    public Foo getFoo();
    public Bar getBar();
}

@Component
class FooConsumer {
    FooConsumer(Foo f);
}