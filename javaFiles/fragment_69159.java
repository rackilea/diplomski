@GET
@Path("advancedService")
@Consumes(MediaType.APPLICATION_JSON)
public Response advancedService(AdvancedServiceInput input, @QueryParam("normalParam") int normalParam, @QueryParam("normalBoolean") boolean normalBoolean) {
    //Do stuff using both input.entity1 and input.entity2.
    return Response.ok().build();
}