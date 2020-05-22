@Configuration
@EnableAspectJAutoProxy
class Config {

    private static final AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
    static {
        proxyFactory.setTargetClass(Something.class);
        proxyFactory.addAspect(SomeAspect.class);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Something something() {

        return proxyFactory.getProxy();
    }
}