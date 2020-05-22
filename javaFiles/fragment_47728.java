@GET
@Produces(MediaType.APPLICATION_JSON)
public Response returnDatabaseAll(@QueryParam("city") String city) throws Exception{
String returnString = null;
JSONArray json = new JSONArray();
try{
    greatontimeSchema dao = new greatontimeSchema();
    json = dao.returnAll(city);
    returnString = json.toString();
}catch (SQLException ex){
    ex.printStackTrace();
    return Response.status(500).entity("Server was not able").build();
}catch(Exception e){
    e.printStackTrace();
    return Response.status(500).entity("Server was not able").build();
}
return Response.ok(json).build();
}