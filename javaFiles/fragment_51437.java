@Override
    public boolean handleMessage(SOAPMessageContext context) {
      //This property checks whether the handler is being invoked for a service response
      boolean response= ((Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue(); 

      if (response) {
          //this is underlying http response object
          HttpServletResponse response = (HttpServletResponse) context.get(MessageContext.SERVLET_RESPONSE);

          //add your desired header
          response.addHeader("Operation", "something");
          }
      return true;
    }