public void writeTo(DataObject dataObject, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
    try {
        throw new JAXBException("error");
    } catch(JAXBException e) {
        Response response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                                     .entity("HI")
                                     .type("text/plain")
                                     .build();
        throw new WebApplicationException(response);
    }
}