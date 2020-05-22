public void receive(MessageContext messageContext) throws Exception {
    // Let's keep a reference to the request content as it came in, it might be changed by interceptors in dispatch()
    String requestContent = "";
    if (receivedMessageTracingLogger.isTraceEnabled()) {
        requestContent = getMessageContent(messageContext.getRequest());
        receivedMessageTracingLogger.trace("Received request [" + requestContent + "]");
    }
    else if (receivedMessageTracingLogger.isDebugEnabled()) {
        receivedMessageTracingLogger.debug("Received request [" + messageContext.getRequest() + "]");
    }
    dispatch(messageContext);
    if (messageContext.hasResponse()) {
        WebServiceMessage response = messageContext.getResponse();
        if (sentMessageTracingLogger.isTraceEnabled()) {
            String responseContent = getMessageContent(response);
            sentMessageTracingLogger.trace("Sent response [" + responseContent + "] for request [" +
                            requestContent + "]");
        }
        else if (sentMessageTracingLogger.isDebugEnabled()) {
            sentMessageTracingLogger.debug("Sent response [" + response + "] for request [" +
                    messageContext.getRequest() + "]");
        }
    }
    else if (sentMessageTracingLogger.isDebugEnabled()) {
        sentMessageTracingLogger
                .debug("MessageDispatcher with name '" + beanName + "' sends no response for request [" +
                        messageContext.getRequest() + "]");
    }

    private String getMessageContent(WebServiceMessage message) throws IOException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    message.writeTo(bos);
    return bos.toString("UTF-8");
}