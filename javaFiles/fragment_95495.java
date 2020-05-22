public class HeaderParamResolverBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(UserAuthHeaderParamValueFactoryProvider.class)
                .to(ValueFactoryProvider.class)
                .in(Singleton.class);

        bind(UserAuthHeaderParamResolver.class)
                .to(new TypeLiteral<InjectionResolver<UserAuthHeaderParam>>() {})
                .in(Singleton.class);
    }
}