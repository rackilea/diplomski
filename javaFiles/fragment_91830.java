public class CacheOutputInterceptor extends AbstractPhaseInterceptor<Message> {

    public CacheOutputInterceptor() {
        super(Phase.PRE_STREAM);
        addAfter(LoggingOutInterceptor.class.getName());
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        final OutputStream os = message.getContent(OutputStream.class);

        if (os != null && !(os instanceof CachedOutputStream) ) {
            final CacheAndWriteOutputStream newOut = new CacheAndWriteOutputStream(os);
            message.setContent(OutputStream.class, newOut);
        }

    }

}