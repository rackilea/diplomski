public static class FoobarMessageBodyReader implements MessageBodyReader<Foobar> {

    private Unmarshaller unmarshaller;

    public RespostaIncluirMessageBodyReader() throws JAXBException {
        unmarshaller = JAXBContext.newInstance(Foobar.class).createUnmarshaller();
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type.isAssignableFrom(Foobar.class);
    }

    @Override
    public Foobar readFrom(Class<Foobar> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        try {
            return (Foobar) unmarshaller.unmarshal(entityStream);
        }
        catch (JAXBException e) {
            throw new IOException("Could not unmarshal the XML output", e);
        }
    }

}