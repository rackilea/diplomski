public class MyProcessor implements Processor {
    private static final Logger LOG = LoggerFactory.getLogger(HttpStreamCache.MyProcessor.class);
    @Override
    public void process(final Exchange exchange) throws Exception {
        LOG.info("***** Body Type: " + exchange.getIn().getBody().getClass().getCanonicalName());
        LOG.info("***** In msg1  : " + exchange.getIn().getBody(String.class));
        LOG.info("***** In msg2  : " + exchange.getIn().getBody(String.class));
    }
};