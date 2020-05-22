@Override
public boolean isFatal(Throwable t) {
    if (t instanceof ListenerExecutionFailedException
            && t.getCause() instanceof MessageConversionException) {
        if (logger.isWarnEnabled()) {
            logger.warn("Fatal message conversion error; message rejected; "
                    + "it will be dropped or routed to a dead letter exchange, if so configured: "
                    + ((ListenerExecutionFailedException) t).getFailedMessage(), t);
        }
        return true;
    }
    return false;
}