@OPTIONS
@Compress
@Path("/mypost")
@Consumes({ MediaType.MULTIPART_FORM_DATA })
@Produces({ MediaType.APPLICATION_JSON })
public Response mypost_opts() {
    return Response.ok().build();
}



@POST
@Compress
@Path("/mypost")
@Consumes({ MediaType.MULTIPART_FORM_DATA })
@Produces({ MediaType.APPLICATION_JSON })
public Response mypost() {
    return Response.ok().build();
}