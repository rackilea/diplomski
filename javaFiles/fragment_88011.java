@Bean
public HttpTraceRepository httpTraceRepository() {
    return new AccessLoggingHttpTraceRepositoryDecorator(
            new InMemoryHttpTraceRepository(),
            LoggerFactory.getLogger("netty.Access"),
            new HttpTraceLogFormatter()
    );
}

public class AccessLoggingHttpTraceRepositoryDecorator implements HttpTraceRepository {

    private HttpTraceRepository delegate;
    private Logger logger;
    private HttpTraceLogFormatter formatter;

    public AccessLoggingHttpTraceRepositoryDecorator(HttpTraceRepository delegate, Logger logger, HttpTraceLogFormatter formatter) {
        this.delegate = delegate;
        this.logger = logger;
        this.formatter = formatter;
    }

    @Override
    public List<HttpTrace> findAll() {
        return delegate.findAll();
    }

    @Override
    public void add(HttpTrace trace) {
        if (logger.isDebugEnabled()) {
            try {
                logger.debug(formatter.format(trace));
            } catch (Exception e) {
                logger.error("Failed to log trace " + trace, e);
            }
        }
        delegate.add(trace);
    }
}

public class HttpTraceLogFormatter {
    public String format(HttpTrace trace) {
        // TODO implement this according to your preference
        return ...;
    }
}