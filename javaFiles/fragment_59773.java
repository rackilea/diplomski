@GET
@Produces("application/vnd.test;version=1")
public Response test1() {
    return Response.ok("Version 1", "application/vnd.test").build();
}

@GET
@Produces("application/vnd.test;version=2")
public Response test2() {
    return Response.ok("Version 2", "application/vnd.test").build();
}