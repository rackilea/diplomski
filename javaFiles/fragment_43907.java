public class ExtendedExample {

    static class ApplicationEvent {
        long identifier;
        String detail;
        long timestamp;

        public ApplicationEvent initialize(long identifier, String detail, long timestamp) {
            this.identifier = identifier;
            this.detail = detail;
            this.timestamp = timestamp;
            return this;
        }
    }

    static private final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws Exception {
        int count = Integer.parseInt(args[0]);
        System.gc();
        Thread.sleep(10000);

        final ApplicationEvent event = new ApplicationEvent();
        for(int i = 0; i < count; i++) {
            event.initialize(i, "ABCD_EVENT", System.currentTimeMillis());
            onApplicationEvent(event);
        }
    }


    private static class ApplicationEventLogMessage extends ReusableObjectMessage {

        private final String eventType = ApplicationEvent.class.getSimpleName();
        private long eventTimestamp;
        private String eventDetail;
        private long eventIdentifier;

        private final StringBuilderFormattable formattable = new StringBuilderFormattable() {
            @Override
            public void formatTo(StringBuilder buffer) {
                buffer.append('{')
                        .append("eventType").append('=').append(eventType).append(", ")
                        .append("eventTimestamp").append('=').append(eventTimestamp).append(", ")
                        .append("eventDetail").append('=').append(eventDetail).append(", ")
                        .append("eventIdentifier").append('=').append(eventIdentifier)
                        .append('}');
            }
        };

        ReusableObjectMessage prepare(ApplicationEvent applicationEvent){
            // It is very important that we call set(), every time, before we pass this to the logger -
            // as the logger will clear() it.
            set(formattable);
            eventTimestamp = applicationEvent.timestamp;
            eventDetail = applicationEvent.detail;
            eventIdentifier = applicationEvent.identifier;
            return this;
        }

    }


    final static ApplicationEventLogMessage reusableEventLogMessage = new ApplicationEventLogMessage();
    private static void onApplicationEvent(ApplicationEvent applicationEvent) {
        logger.info( reusableEventLogMessage.prepare(applicationEvent) );
    }
}