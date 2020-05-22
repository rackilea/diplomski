@Path("/")
public class StaticService
{

    @GET
    @Path("/{docPath:.*}.{ext}")
    public Response getHtml(@PathParam("docPath") String docPath, @PathParam("ext") String ext, @HeaderParam("accept") String accept)
    {
        File file = new File(cleanDocPath(docPath) + "." + ext);
        return Response.ok(file).build();
    }

    @GET
    @Path("{docPath:.*}")
    public Response getFolder(@PathParam("docPath") String docPath)
    {
        File file = null;
        if ("".equals(docPath) || "/".equals(docPath))
        {
            file = new File("index.html");
        }
        else
        {
            file = new File(cleanDocPath(docPath) + "/index.html"); 
        }
        return Response.ok(file).build();
    }

    private String cleanDocPath(String docPath)
    {
        if (docPath.startsWith("/"))
        {
            return docPath.substring(1);
        }
        else
        {
            return docPath;
        }
    }
}