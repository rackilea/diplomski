import javax.servlet.Filter;
...

@Configuration / @SpringBootApplication
class Something {

    @Bean
    public Filter loggingFilter(){
        return new AbstractRequestLoggingFilter() {
            private final Logger log = LoggerFactory
                    .getLogger(Something.class);

            {
                setIncludeClientInfo(true);
                setIncludeQueryString(true);
                setIncludePayload(true);
            }

            @Override
            protected void beforeRequest(HttpServletRequest request, String message) {
                // not needed
            }

            @Override
            protected void afterRequest(HttpServletRequest request, String message) {
                log.info(message);
            }
        };
    }