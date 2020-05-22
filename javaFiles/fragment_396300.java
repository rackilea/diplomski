@GET
@Produces(MediaType.TEXT_PLAIN)
public String getToken() {
    String apiToken = ...
    return apiToken;  
}