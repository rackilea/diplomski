@Context
protected UriInfo uriInfo;

@Context
protected WadlApplicationContext wadlContext;

@GET
@Path("/wadl")
@Produces({"application/vnd.sun.wadl+xml", MediaType.APPLICATION_XML})
public Response wadl() {

        // most of this is lifted from org.glassfish.jersey.server.wadl.internal.WadlResource
        try {
            boolean detailedWadl = WadlUtils.isDetailedWadlRequested(uriInfo);
            String lastModified = new SimpleDateFormat(WadlResource.HTTPDATEFORMAT).format(new Date());
            ApplicationDescription applicationDescription = wadlContext.getApplication(uriInfo, detailedWadl);
            Application application = applicationDescription.getApplication();
            application.getResources().stream().findFirst().get().getResource().removeIf(resource -> !resource.getPath().startsWith("/public_api"));
            ByteArrayInputStream wadl = marshal(application);
            return Response.ok(wadl).header("Last-modified", lastModified).build();
        } catch (Exception e) {
            throw new ProcessingException("Error generating WADL", e);
        }
}