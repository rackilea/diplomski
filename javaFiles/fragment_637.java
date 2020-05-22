@GET
@Path("/some-path")
public Response myMethod(@Context HttpServletRequest request) {

    boolean isParameterPresent = request.getParameterMap().contains("bar");

    ...
}