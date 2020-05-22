@Path("upload/{id}")
@GET
public Response getPDF(@PathParam("id") Integer id) throws Exception {
    ClientCaseDoc entity = find(id);
    return Response
            .ok()
            .type("application/pdf")
            .entity(entity.getDocument()) // Assumes document is a byte array in the domain object.
            .build();
}