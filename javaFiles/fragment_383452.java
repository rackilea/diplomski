@Api(name = "myapi", version = "v1", authenticators  = {MyDummyAuthenticator.class})
public class MyAPI {
  @ApiMethod(name = "hylyts.get")
  public Hylyt getHylyt(@Named("url") String url, @Named("id") long id, User user)
        throws OAuthRequestException, UnauthorizedException {
    return ofy().load().type(Hylyt.class).parent(util.getArticleKey(url, user)).id(id).now();
  }
}