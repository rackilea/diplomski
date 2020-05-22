...
Dispatch<SOAPMessage> dispatch =  
 service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);    
Map<String, List<String>> headers = 
      new HashMap<String, List<String>>();
headers.put("OperationName", someOperation);    
dispatch.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS,
  headers);
...