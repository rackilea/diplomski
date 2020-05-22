final class SkipWaitInterceptor extends AbstractSoapInterceptor {

    SkipWaitInterceptor() {
        super(Phase.SETUP);
    }

    @Override
    public void handleMessage(final SoapMessage message) throws Fault {
        message.getExchange().setSynchronous(false);
    }

}