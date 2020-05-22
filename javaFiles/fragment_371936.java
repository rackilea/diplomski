@PUT
@Path("{storage}/{repository}/{path:.*}")
public void upload(@PathParam("storage") String storage,
                   @PathParam("repository") String repository,
                   @PathParam("path") String path,
                   @Context HttpServletRequest request)
        throws IOException,
               AuthenticationException
{
    System.out.println("Using protocol " + request.getRequestURL().toString().split(":")[0]);
}