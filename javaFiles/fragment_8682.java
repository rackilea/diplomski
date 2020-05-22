@Path("/configuration")
public class Configuration { // Some class name
    @GET
    @Path("/check")    // configuration/check comes from your request url
    public Response analysis(@Context HttpServletRequest req) {
        JSONObject conf = new JSONObject();
        try{
            myProcess();
            return Response.ok().build();
        } catch(Exception e) {
        e.printStackTrace();
        JSONObject response = new JSONObject();
        response.put(RESTApplication.ERRORCODE, "S001");
        response.put(RESTApplication.MESSAGE, "Error occurs");
        return Response.serverError().entity(response).type(MediaType.APPLICATION_JSON).build();
    }
}