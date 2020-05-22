else if(!(this.handler instanceof AbstractReplyProducingMessageHandler)) {
    if (logger.isDebugEnabled()) {
            logger.debug("adviceChain can only be set to AbstractReplyProducingMessageHandler or its subclass, "
                    + ((IntegrationObjectSupport) this.handler).getComponentName() + " doesn't support it.");
                }
}