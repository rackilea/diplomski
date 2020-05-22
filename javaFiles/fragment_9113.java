import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api/customers")
public class CustomerProcessor {

    @Path("/")
    @Produces({ MediaType.APPLICATION_XML })
    @GET
    public Response getCustomerData() {
        // get the customer list - assume that it's a String
        String customerXML = ...;

        return Response.ok(customerXML).build();
    }

    @Path("/{customerId}")
    @Produces({ MediaType.TEXT_PLAIN }) # not sure of the return type
    @GET
    public Response getCustomer(@PathParam("customerId") Integer customerId) {
        // customerId is set to what is on the url but you didn't parse it
        Customer customer = getCustomer(customerId);

        return Response.ok(customer).build();
    }
}