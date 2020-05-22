MessageContext responseMessageContext =  
    MessageContext.getCurrentMessageContext();
HttpServletResponse resp =
    (HttpServletResponse) responseMessageContext.getProperty(
    org.apache.axis2.transport.http.HTTPConstants.MC_HTTP_SERVLETRESPONSE);
resp.setStatus(422);