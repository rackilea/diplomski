protected HttpServletRequest getServletRequestObject() {
    MessageContext msgContext = wsContext.getMessageContext();
    HttpServletRequest request = (HttpServletRequest) msgContext.get(MessageContext.SERVLET_REQUEST);
    this.log.info("Request from {} at {}", request.getRemoteHost(), request.getRemoteAddr());
    return request;
}