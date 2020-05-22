@Configuration
public class FactoryBeanAppConfig {
    @Bean
    public HandlerExceptionResolver sentryExceptionResolver() {
        return new SentryExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest request,
                    HttpServletResponse response,
                    Object handler,
                    Exception ex) {
                Throwable rootCause = ex;

                while (rootCause .getCause() != null && rootCause.getCause() != rootCause) {
                    rootCause = rootCause.getCause();
                }

                if (!rootCause.getMessage().contains("Broken pipe")) {
                    super.resolveException(request, response, handler, ex);
                }
                return null;
            }   

        };
    }

    @Bean
    public ServletContextInitializer sentryServletContextInitializer() {
        return new SentryServletContextInitializer();
    }
}