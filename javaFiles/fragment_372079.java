protected JmsMessageType getJMSMessageTypeForBody(Exchange exchange, Object body, Map<String, Object> headers, Session session, CamelContext context) {
    JmsMessageType type = null;
    // let body determine the type
    if (body instanceof Node || body instanceof String) {
        type = Text;
    } else if (body instanceof byte[] || body instanceof WrappedFile || body instanceof File || body instanceof Reader
            || body instanceof InputStream || body instanceof ByteBuffer || body instanceof StreamCache) {
        type = Bytes;
    } else if (body instanceof Map) {
        type = Map;
    } else if (body instanceof Serializable) {
        type = Object;            
    } else if (exchange.getContext().getTypeConverter().tryConvertTo(File.class, body) != null
            || exchange.getContext().getTypeConverter().tryConvertTo(InputStream.class, body) != null) {
        type = Bytes;
    }
    return type;
}