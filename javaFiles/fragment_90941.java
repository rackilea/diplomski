public class UserApiServiceImpl extends UserApiService {
      // methods omitted...
      @Override
      public Response getUserByName(String username, SecurityContextsecurityContext) throws NotFoundException {
          // do some magic!
          return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    // methods omitted...
}