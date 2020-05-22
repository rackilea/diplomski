@GET
    @Produces(MediaType.APPLICATION_XML)
    public Response get() {
        Customer customer = new Customer();
        customer.setFirstName("Jane");
        customer.setLastName("Doe");
        JAXBElement<Customer> jaxbElement = new JAXBElement(new QName("FOO"), Customer.class, customer);
        return Response.ok(jaxbElement).build();
    }