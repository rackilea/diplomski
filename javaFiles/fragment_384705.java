@GET
@Path("/college/{params: .*}")
public Response get(@PathParam("params") List<PathSegment> params) {
    StringBuilder builder = new StringBuilder();
    for (PathSegment seg: params) {
        builder.append(seg.getPath());
    }
    return Response.ok(builder.toString()).build();
}