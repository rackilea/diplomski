@Named 
@Path("/users") 
@ValidateRequest 
public class UserResource extends BaseResource 
{   
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createUser(@Valid User user)
    {
        //Do Something Here
    }
}