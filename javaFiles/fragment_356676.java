@Component
public class LogsFlusher {

    private static final Logger LOG = LoggerFactory.getLogger(LogsFlusher.class);

    @PreDestroy
    public void flushLogs() {
        LOG.info("Shutdown logger context.");
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.stop();
    }
}