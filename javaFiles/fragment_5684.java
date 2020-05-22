public void writeTo(Object object, Class<?> type, Type genericType,
    Annotation[] annotations, MediaType mediaType,
    MultivaluedMap<String, Object> httpHeaders,
    OutputStream entityStream) throws IOException,
    WebApplicationException {
    try {
        ContextResolver<JAXBContext> resolver 
            = providers.getContextResolver(JAXBContext.class, mediaType);
        JAXBContext jaxbContext;
        if(null == resolver || null == (jaxbContext = resolver.getContext(type))) {
            jaxbContext = JAXBContext.newInstance(type);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer(xslt);
        JAXBSource source = new JAXBSource(jaxbContext, object);
        StreamResult result = new StreamResult(entityStream);
        t.transform(source, result);
    } catch(JAXBException jaxbException) {
        throw new WebApplicationException(jaxbException);
    }
}