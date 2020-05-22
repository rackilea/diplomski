@POST
@Path("/somepath")
public Response doSomething(@QueryParam("userEmail") String userEmail, @QueryParam("userId") String userId) {
    if(userEmail != null && !userEmail.equals("")) {
        //use email address
    } else if(userId != null && !userId.equals("")) {
        //use user id
    } else {
        throw new RuntimeException()
    }
}