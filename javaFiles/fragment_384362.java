public class RestClient {
    private Client client;
    private WebResource webResource;

    public RestClient() {
        super();
    }

    public User getUser(String userName) throws UniformInterfaceException {
        final WebResource userResource = webResource
           .path(String.format("/user/%s", userName))
           .accept(MediaType.TEXT_XML) ;
        return userResource.get(User.class);
    }

    public Collection<Tweet> getTweets(String userName) throws UniformInterfaceException {
        final WebResource tweetResource = webResource
           .path(String.format("/user/%s/tweets", userName))
           .accept(MediaType.TEXT_XML) ;
        return tweetResource.get(new GenericType<Collection<Tweet>>(){});
    }
}