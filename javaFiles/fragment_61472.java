public class MyResolverBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(MyInjectionResolver.class)
                .to(new TypeLiteral<InjectionResolver<MyAnnotation>>() {})
                .in(Singleton.class);
    }
}