@Override
public void writeTo(Customer c, Class<Customer> type, 
                    Type genericType, Annotation[] annotations, 
                    MediaType mediaType, 
                    MultivaluedMap<String,Object> httpHeaders, 
                    OutputStream entityStream) {

    JAXBContext context = JAXBContext.newInstance(type);
    Marshaller marsaller = context.createMarshaller();
    marshaller.marshal(c, entityStream);
}