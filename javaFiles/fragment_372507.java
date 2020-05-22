@Configuration
public class FactoryBeanAppConfig {
    @Bean
    public HandlerExceptionResolver sentryExceptionResolver() {
        return new SentryExceptionResolver() {
                @Override
                public int getOrder() {
                    // ensure we can get some resolver earlier than this
                    return 10;
                }
         };
    }

    @Bean
    public ServletContextInitializer sentryServletContextInitializer() {
        return new SentryServletContextInitializer();
    }
}