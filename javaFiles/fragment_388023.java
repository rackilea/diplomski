@Path("resources")
@Stateless
public class MyResources{
    @Resource(name="myDataSource")
    DataSource dataSource;

    @GET
    public Response SomeMethod(){
         //Do stuff here
    }
}