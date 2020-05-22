Class Aux{
String xml;
String plant;
//generate gettes and setters :)
}
@Path("/example")
public class PdfMaker { 
@POST
@Path("/post")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response PruebasMet(Aux json) throws IOException, 
JSONException{
    try{
    String xml = json.getXml();
    String plant = json.getPlant();
    //method that uses "xml" and "plant" and returns "pdf" 

    JSONObject response = new JSONObject();
    response.put("pdf", pdf);

return Response.status(200).entity(pdf)).build();
    }catch(Exception e){
        e.getStackTrace();
        return null;
    }