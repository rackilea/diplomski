@POST
@Path("/json-map")
@Consumes(MediaType.APPLICATION_JSON)
public SomeSortOfResponse receiveArbitraryJsonMap(Map<String,String> map) {
    // do stuff with map of key-value pairs
}