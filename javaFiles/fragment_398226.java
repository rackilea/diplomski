@Path("/employee")
public class EmployeeResource {
    @GET
    @Path("list")
    @Async
    public void getEmployeeDetails(){
        //DAO call and other stuff

        new Thread(new Runnable() {
           public void run() {
              mailClient.sendMail();
           }
        }).start();
    }
}