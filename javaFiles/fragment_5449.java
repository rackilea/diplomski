@PUT
@Path("logout")
@Produces({"application/json", "text/plain"})
public String logout(String data) throws Exception {
     String response = null;
     reponse = new UserManager().logout(data);
     return response;
}