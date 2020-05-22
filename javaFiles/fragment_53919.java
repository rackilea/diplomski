class SOAPLoggingHandler implements SOAPHandler<SOAPMessageContext> {
    public Set<QName> getHeaders() {
      return null;
    }

    public boolean handleMessage(SOAPMessageContext smc) {
      logToSystemOut(smc);
      return true;
    }

    public boolean handleFault(SOAPMessageContext smc) {
      logToSystemOut(smc);
      return true;
    }

    public void close(MessageContext messageContext) {
    }

    private void logToSystemOut(SOAPMessageContext smc) {
      Boolean outboundProperty = (Boolean)
              smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

      if (outboundProperty.booleanValue()) {
        System.out.println("\nOutbound message:");
      }
      else {
        System.out.println("\nInbound message:");
      }

      SOAPMessage message = smc.getMessage();
      try {
        message.writeTo(System.out);
        System.out.println("");
      }
      catch (Exception e) {
        System.out.println("Exception in handler: " + e);
      }
    }
  }