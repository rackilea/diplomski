@GET
@Path("/us")
@Produces(MediaType.APPLICATION_JSON)
public Response getJson() { //javax.ws.rs.core.Response
    VersionOld vo = new VersionOld();
    vo.versions.put("ap", "Not set");
    vo.versions.put("am", "topic-test-publisher-1.0.16");
    vo.versions.put("il", "topic-test-publisher-1.0.16");
    vo.versions.put("row", "topic-test-publisher-1.0.49");
    vo.provider = "gce";


    return Response.status(200).entity(vo).build();
}