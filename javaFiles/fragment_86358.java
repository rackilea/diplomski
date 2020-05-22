@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
@Path("/pusher/auth")
public String processMessagesAndAuthentication( MultivaluedMap<String, String> input){
    Pusher pusher = new Pusher("APP-ID", "PUSHER-KEY", "PUSHER-SECRET-KEY");
    String userId = "12345"; //any unique id
    Map<String, String> userInfo = new HashMap<>();
    userInfo.put("name", "Bharti Rawat");
    userInfo.put("twitterId", "@leggetter");
    String socket_id = input.getFirst("socket_id");
    String channel_name = input.getFirst("channel_name");
    String auth = pusher.authenticate(socket_id, channel_name, new PresenceUser(userId, userInfo));
    return auth;
}