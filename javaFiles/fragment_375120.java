@Path("/storeMovement")
@POST
@Consumes("application/json")
@Produces("application/json")
public String storeTrace(String json) {
    JSONObject response = new JSONObject();
    JSONParser parser = new JSONParser();
    String ret = "";

    try {
        Object obj = parser.parse(json);
        JSONObject jsonObj = (JSONObject) obj;

        RecordMovement re = new RecordMovement((double) jsonObj.get("longitude"), (double) jsonObj.get("latitude"), (long) jsonObj.get("IMSI"));
        ret = re.Store();

        // Clear object
        re = null;
        System.gc();

        response.put("status", ret);
    } catch (Exception e) {
        response.put("status", "fail " + e.toString());
    }
    return response.toJSONString();
}