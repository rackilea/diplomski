public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
    if (logFault && logger.isDebugEnabled()) {
        logMessageSource("Fault: ", getSource(messageContext.getResponse()));
    }
    return true;
}