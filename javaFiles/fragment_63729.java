@Provider
@Consumes(MediaType.APPLICATION_XML)
public class MyJAXBMessageBodyReader 
                   implements MessageBodyReader<Customer> {
    @Override
    public boolean isReadable(Class<Customer> type, Type genericType, 
                              Annotation[] annotations, MediaType mediaType) {

        return type == Customer.class
    }
}

@POST
@Consumed(MediaType.APPLICATION_XML)
public Response createCustomer(Customer customer) {
    customerService.save(customer);
    return Response.created(newCustomerUri).build();
}