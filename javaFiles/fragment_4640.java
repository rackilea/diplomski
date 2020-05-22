@Path("/FriendsList")
public class RestWebServicesAPI{

@POST
@Path("/friends")
@Consumes(MediaType.APPLICATION_JSON)
public Friends saveFriendList(final String json){
    Gson gs = new Gson();
    Friends [] n = gs.fromJson(json, Friends [].class);

}
//ALTERNATIVE
@POST
    @Path("/friends")
    @Consumes(MediaType.APPLICATION_JSON)
    public Friends saveFriendList(final Friends[] friends){


    }