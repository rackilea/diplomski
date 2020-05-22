@PUT
@Path("/customers/{id}")
@Consumes(MediaType.APPLICATION_JSON)
public Response updateCustomer(@PathParam("id") long id, 
                               Customer updateCustomer) {

    Customer customer = customerService.getCustomerById(id);
    if (customer == null) {
        throw new WebApplicationException("Can't find it", 404);
    }

    customer.setFirstName(updateCustomer.getFirstName());
    customer.setLastName(updateCustomer.getLastName());
    ...

    return Response.noContent().build();
}