public class MyInterceptor extend ClientInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    private EndpointInterceptor endpointInterceptor = new AbstractLoggingInterceptor() {
        @Override
        protected Source getSource(WebServiceMessage webServiceMessage) {
            // Base logic same as SoapEnvelopeLoggingInterceptor getSource method.You can adjust to your preference.
            if(webServiceMessage instanceof SoapMessage) {
                SoapMessage soapMessage = (SoapMessage)webServiceMessage;
                return soapMessage.getEnvelope().getSource();
            } else {
                return null;
            }
        }
        @Override
        protected void logMessage(String message) {
            // You can use your regex to remove the attribute and log the message.
            this.logger.debug(message);
        }
    };

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        return endpointInterceptor.handleRequest(messageContext, null);

    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        return endpointInterceptor.handleResponse(messageContext, null);

    }

}