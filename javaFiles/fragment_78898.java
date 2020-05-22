SyncProcessDAO client = (SyncProcessDAO)factory.create();
Map<String, Object> requestContext =   ((BindingProvider)client).getRequestContext();                              
Map<String, List<String>> requestHeaders = new HashMap<String, List<String>>();
requestHeaders.put("username", "user");
requestHeaders.put("Password", "pwd");
requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);