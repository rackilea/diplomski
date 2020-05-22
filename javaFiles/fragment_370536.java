@GET
@Path("/stuff/{id}")
public Response getById(@PathParam("id") String id, @QueryParam("bar") String bar) {           
    try { 
        int intId = Integer.parseInt(id);
        // do int id things
    } catch(NumberFormatException e) { 
        // do foo + bar things
    }
}