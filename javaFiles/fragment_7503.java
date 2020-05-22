@POST
@Path("/somepath")
public Response doSomething(userDTO user) {
    if(user.getUserEmail() != null && !user.getUserEmail().equals("")) {
        //use email address
    } else if(user.getUserId() != null && !user.getUserId().equals("")) {
        //use user id
    } else {
        throw new RuntimeException()
    }
}