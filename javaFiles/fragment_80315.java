@Path("/user/service")
public class UserServices {

  @Path("/getUser")
  @GET
  public void getUser() { System.out.println("Inside GET method"); }

  @Path("/updateUser")
  @POST
  public void updateUser() { System.out.println("Inside UPDATE method"); } 

  @Path("/deleteUser")
  @DELETE
  public void deleteUser() { System.out.println("Inside DELETE method"); }
}