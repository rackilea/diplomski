@Path("users")
@ApplicationScoped
public class UserResource {

    @Inject
    private GetUser getUser;

    @GET
    public Response getUser(@QueryParam("userId") String userId) {
        return UserRepresentationMapper.toRepresentation(getUser.getUser(userId);
    }
}