@Override
public Customer readFrom(Class<T> type, Type genericType, 
                         Annotation[] annotations, MediaType mediaType,
                         MultivaluedMap<String,String> httpHeaders,
                         InputStream entityStream) throws IOException,
                         WebApplicationException {

    JAXBContext context = JAXBContext.newInstance(Customer.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();

    return (Customer)unarshaller.unmarshal(entityStream);
}