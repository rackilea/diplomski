@PUT
@Consumes("application/json")
@Path("/Id/{Id}/version/{version}/addPerson")
public Response addPerson(@PathParam("Id") String Id,
                          @PathParam("version") String version,
                          List<NamObj> names) {