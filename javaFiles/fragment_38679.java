@Path("customers")
public class CustomerResource {
    @Inject
    private CustomerService service;

    @GET
    public List<Customer> findAll() {
        return service.findAll();
    }
}