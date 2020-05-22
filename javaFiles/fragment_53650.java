@RequestScoped
@Path("customer")
public class CustomerResource {

    @Context
    private HttpHeaders headers;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCustomer(@Valid Customer pCustomer) {
        return Response.ok(pCustomer).build();
    }

    String getHeaderString(String headerName) {
        return headers.getHeaderString(headerName);
    }
...