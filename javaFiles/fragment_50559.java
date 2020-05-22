@Configuration
public class MyServiceFactoryBean {
    @Bean
    public FactoryBean serviceLocatorFactoryBean(){
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(MyServiceFactory.class);
        return factoryBean;
    }

    @Bean("myService")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DefaultService defaultService(){
        return new DefaultService();
    }

    @Bean("myService2")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DefaultService2 defaultService2(){
        return new DefaultService2();
    }
}