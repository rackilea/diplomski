@Path("customers/{customerId}")
public Customer findCustomer(@PathParam("customerId") Long customerId) {
    Customer customer = customerService.find(customerId);
    if (customer == null) {
        throw new CustomerNotFoundException("Customer not found with ID " + customerId);
    }
    return customer;
}