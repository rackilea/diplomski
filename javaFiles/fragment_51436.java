@Override
    public boolean handleMessage(SOAPMessageContext context) {
      //This property checks whether the handler is being invoked for a service response
      boolean response= ((Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue(); 

      if (response) {
          //this is a JAX-WS-provided map of HTTP headers
          Map<String, List<String>> headers = (Map<String, List<String>>) context.get(MessageContext.HTTP_RESPONSE_HEADERS);
          if (null == headers) {
              //create a new map of HTTP headers if there isn't already one
              headers = new HashMap<String, List<String>>();
          }
          //add your desired header
          headers.put("Operation",Collections.singletonList("something");
        }
      return true;
    }