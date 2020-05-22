@POST
@Path("CreateADGroup")
@Produces(MediaType.APPLICATION_JSON)
@Consumes("application/json")
@RequiredRight(value = "createADGroup")
public Map postCreateADGroup(Map requestValues) {
    log.debug("POST CreateADGroup");
    log.debug("This is the value" + requestValues.get("value"));
    Map ret = new HashMap();
    ret.put("Val", "No Val");
    return ret;
}