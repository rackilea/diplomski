@Override
    protected final boolean resolveExceptionInternal(MessageContext messageContext, Object endpoint, Exception ex) {

        MethodEndpoint methodEndpoint = (MethodEndpoint)endpoint;

        if(methodEndpoint != null && methodEndpoint.getBean().getClass().getSimpleName().equalsIgnoreCase(getEndpointClass().getSimpleName()))
            {
            Assert.isInstanceOf(SoapMessage.class, messageContext.getResponse(),
                    "SimpleSoapExceptionResolver requires a SoapMessage");
            SoapMessage response = (SoapMessage) messageContext.getResponse();
            String faultString = StringUtils.hasLength(ex.getMessage()) ? ex.getMessage() : ex.toString();
            SoapBody body = response.getSoapBody();
            SoapFault fault = body.addServerOrReceiverFault(faultString, getLocale());
            customizeFault(messageContext, endpoint, ex, fault);
            return true;
        }

        return false;
    }