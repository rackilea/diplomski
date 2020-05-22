@Path("/contacts/{id}")
@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response updateContact(@PathParam final String contactId, Contact contact) {
}