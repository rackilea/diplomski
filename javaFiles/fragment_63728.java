@Provider
@Produces(MediaType.APPLICATION_XML)
public class MyJAXBMessageBodyWriter 
                  implements MessaheBodyWriter<Customer> {
    @Override
    public boolean isWriteable(Class<Customer> type, Type genericType, 
                Annotation[] annotations, MediaType mediaType) {

        return type == Customer.class;
    }
}

@GET
@Produces(MediaType.APPLICATION_XML)
public Response getCustomer() {
    Customer customer = customerService.getCustomer();
    return Response.ok(customer).build();
}