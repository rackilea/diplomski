@Import(ProdConfig.class)
public class TestConfig {

    @Autowired
    private SimpleRabbitListenerContainerFactory containerFactory;

    @Bean
    RetryOperationsInterceptor interceptor() {
        ...

        this.containerFactory.setAdviceChain(interceptor);

        return interceptor;
    }

}