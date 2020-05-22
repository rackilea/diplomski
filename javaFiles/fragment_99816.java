@GET
@Timed
@UnitOfWork
@Produces(MediaType.APPLICATION_JSON)
public EntityResponse getOutput() {
    return EntityResponse.success("result string");
}