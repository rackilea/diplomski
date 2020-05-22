@Path("/hello")
public class Hello {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public JSONObject sayPlainTextHello(JSONObject inputJsonObj) throws Exception {

    String input = (String) inputJsonObj.get("input");
    String output = "The input you sent is :" + input;
    JSONObject outputJsonObj = new JSONObject();
    outputJsonObj.put("output", output);

    return outputJsonObj;
  }
}