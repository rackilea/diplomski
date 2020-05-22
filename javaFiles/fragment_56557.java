@Path("/FileManager")
public class fileServlet extends HttpServlet {

    @GET
    @Path("/fileGetter/{fileString}")
   public void doGet(@Context HttpServletRequest request,@Context HttpServletResponse response,@PathParam("fileString") String fileName)
               throws IOException, ServletException {
       OutputStream output = response.getOutputStream();
       //Get the fileID.png
       String fileString = fileName;