@Path("/")
public class AccountResource {
    @GET
    @Path("/account") // route to a specific method.re
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveDataIntoHash() {
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("Stack", "Savings"));
        accounts.add(new Account("Overflow", "Checkings"));
        GenericEntity generic = new GenericEntity<List<Account>>(accounts){};
        return Response.status(201).entity(generic).build();
    }
}