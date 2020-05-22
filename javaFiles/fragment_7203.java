@GET 
@Produces("text/plain")
public String getIt(@QueryParam("query") JSONParam json) {
    DataTransferObject dto = json.getDTO();
    ...
}