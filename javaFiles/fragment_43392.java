@POST
@Path("/json-list")
@Consumes(MediaType.APPLICATION_JSON)
public SomeSortOfResponse receiveArbitraryJsonList(List<String> list) {
    // do stuff with list
}